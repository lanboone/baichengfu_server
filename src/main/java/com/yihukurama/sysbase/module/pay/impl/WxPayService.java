package com.yihukurama.sysbase.module.pay.impl;

import com.alibaba.fastjson.JSON;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.app.designp.observer.AppEventPublisher;
import com.yihukurama.sysbase.module.app.designp.observer.event.ProductEvent;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderProductService;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderService;
import com.yihukurama.sysbase.module.pay.IPay;
import com.yihukurama.sysbase.thirdparty.tencent.wx.pay.WxPaySDKConfig;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.app.utils.XmlUtils;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("WxPayService")
public class WxPayService implements IPay {

    @Autowired
    OrderService orderService;

    @Autowired
    WxPaySDKConfig wxPayConfig;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    AppEventPublisher appEventPublisher;

    @Override
    public Result unifiedOrder(Request<Order> request) throws TipsException {
        Order order = request.getData();
        OrderEntity orderEntity = orderService.load(order);

        //支付类, 所有方法都在这个类里
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        LogUtil.debugLog(this, JSON.toJSONString(wxPayConfig));
        PayRequest payRequest = new PayRequest();
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_APP);
        payRequest.setOrderId(orderEntity.getNum());
        payRequest.setOrderName("用户"+orderEntity.getAppuserId()+"支付账单");
        payRequest.setOrderAmount(orderEntity.getPaidPrice().doubleValue());
        PayResponse payResponse = bestPayService.pay(payRequest);

        return Result.successed(payResponse,"微信下单成功");
    }

    @Override
    public Result refund(Request<Order> request) throws TipsException {
        Order order = request.getData();
        OrderEntity orderEntity = orderService.load(order);

        //支付类, 所有方法都在这个类里
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);

        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_APP);
        refundRequest.setOrderId(orderEntity.getNum());
        refundRequest.setOrderAmount(orderEntity.getPaidPrice().doubleValue());
        RefundResponse refundResponse = bestPayService.refund(refundRequest);

        return Result.successed(refundResponse);
    }

    @Override
    public String payNotfiy(String requestBody) throws TipsException {
        Map<String, String> map = XmlUtils.saxParse(requestBody, "utf-8");

        LogUtil.infoLog(this, "支付回复：==============>" + requestBody);

        if(map == null || map.size() == 0){
            LogUtil.errorLog(this, "解析支付结果失败");
        }

        if(!wxPayConfig.getAppId().equals(map.get("appid"))){
            return responseWxPayFail("非本公众号产生的支付操作");
        }


        if(!EmptyUtil.isEmpty(map.get("req_info"))){
            //退款
            return payCancel(requestBody, map);
        }else {
            //收款
            return paySuccess(requestBody, map);
        }
    }

    /**
     * 说明： 处理付款成功事件
     * @author: yihukurama
     * @date: Created in 18:16 2019/1/7
     * @modified: by autor in 18:16 2019/1/7
     * @param origin 回复原文
     * @param requestBody 微信回复
     * @return 回复微信操作是否成功
     */
    private String paySuccess(String origin, Map<String, String> requestBody){
        try {
            String sign = requestBody.get("sign");
            if (EmptyUtil.isEmpty(sign)) {
                return responseWxPaySuccess();
            }
            BestPayServiceImpl bestPayService = new BestPayServiceImpl();
            bestPayService.setWxPayConfig(wxPayConfig);

            PayResponse payResponse = bestPayService.asyncNotify(origin);
            if(payResponse == null){
                LogUtil.errorLog(this, "支付签名错误：" + origin);
                return responseWxPaySuccess();
            }

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(payResponse.getOrderId());
            orderEntity = orderService.load(orderEntity);
            if(orderEntity == null){
                LogUtil.errorLog(this, "支付成功响应错误,无此条件订单" + origin);
                return responseWxPaySuccess();
            }

            OrderEntity updateOrderEntity = new OrderEntity();
            updateOrderEntity.setId(orderEntity.getId());
            updateOrderEntity.setStatus(Order.PAY_STATUS_20);
            updateOrderEntity.setTradeNo(payResponse.getOutTradeNo());
            orderService.update(updateOrderEntity);

            OrderProductEntity orderProductEntity = new OrderProductEntity();
            orderProductEntity.setOrderId(orderEntity.getId());
            List<OrderProductEntity> orderProductEntityList = orderProductService.list(orderProductEntity);
            for (OrderProductEntity orderProduct:orderProductEntityList) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(orderProduct.getProductId());
                appEventPublisher.publishEvent(new ProductEvent(productEntity,ProductEvent.TYPE_30));
            }


            return responseWxPaySuccess();
        }catch (Throwable e){
            LogUtil.errorLog(this, "处理付款成功事件时报错, 报错信息：" + e.getMessage());
            return responseWxPaySuccess();
        }
    }

    /**
     * 说明： 处理退款成功事件
     * @author: yihukurama
     * @date: Created in 18:16 2019/1/7
     * @modified: by autor in 18:16 2019/1/7
     * @param origin 原文
     * @param requestBody 微信回复
     * @return 回复微信操作是否成功
     */
    private String payCancel(String origin, Map<String, String> requestBody){
        return responseWxPaySuccess();
    }

    private String responseWxPaySuccess(){
        return "<xml>"+
                "<return_code><![CDATA[SUCCESS]]></return_code>"+
                "<return_msg><![CDATA[OK]]></return_msg>"+
                "</xml>";
    }

    private String responseWxPayFail(String msg){
        return "<xml>"+
                "<return_code><![CDATA[FAIL]]></return_code>"+
                "<return_msg><![CDATA["+msg+"]]></return_msg>"+
                "</xml>";
    }
}
