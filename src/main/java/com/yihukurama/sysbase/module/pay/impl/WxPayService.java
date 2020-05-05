package com.yihukurama.sysbase.module.pay.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.common.models.AlipayTradeCreateResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderService;
import com.yihukurama.sysbase.module.pay.IPay;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("WxPayService")
public class WxPayService implements IPay {

    @Autowired
    OrderService orderService;

    @Override
    public Result unifiedOrder(Request<Order> request) throws TipsException {
        Order order = request.getData();
        OrderEntity orderEntity = orderService.load(order);
        return Result.successed("下单成功");
    }

    @Override
    public Result refund(Request<Order> request) throws TipsException {
        Order order = request.getData();
        OrderEntity orderEntity = orderService.load(order);
        return Result.successed("退款成功");
    }

    @Override
    public String payNotfiy(String requestBody) throws TipsException {
        JSONObject payResponse = JSON.parseObject(requestBody);
        if(payResponse!=null){
            String resultStatus = payResponse.getString("resultStatus");
            if(("9000").equals(resultStatus)){
                JSONObject result = payResponse.getJSONObject("result");
                if(result!=null){
                    //订单号
                    String out_trade_no = result.getString("out_trade_no");
                    //支付宝流水号
                    String trade_no = result.getString("trade_no");
                    //金额
                    String total_amount = result.getString("total_amount");
                    if(EmptyUtil.isEmpty(out_trade_no)
                    || EmptyUtil.isEmpty(trade_no)
                    || EmptyUtil.isEmpty(total_amount)){
                        LogUtil.errorLog(this,"支付宝回调出现问题,result错误，回调参数为:"+JSON.toJSONString(requestBody));

                    }
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setNum(out_trade_no);
                    orderEntity = orderService.loadOneByCondition(orderEntity);
                    if(orderEntity == null){
                        LogUtil.errorLog(this,"支付宝回调出现问题,找不到订单,回调参数为:"+JSON.toJSONString(requestBody));
                    }
                    BigDecimal total = new BigDecimal(total_amount);
                    if(!orderEntity.getPaidPrice().equals(total)){
                        LogUtil.errorLog(this,"支付宝回调出现问题,支付金额与订单金额不一致,回调参数为:"+JSON.toJSONString(requestBody));
                    }
                    orderEntity.setTradeNo(trade_no);
                    orderService.update(orderEntity);
                }
            }else{
                LogUtil.errorLog(this,"支付宝回调出现问题,参数为:"+JSON.toJSONString(requestBody));
            }
        }
        return null;
    }
}
