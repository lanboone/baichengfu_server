package com.yihukurama.sysbase.module.pay.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.common.models.AlipayTradeCreateResponse;
import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.common.utils.StringUtil;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderProductService;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderService;
import com.yihukurama.sysbase.module.pay.IPay;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import net.bytebuddy.pool.TypePool;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AliPayService implements IPay {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderProductService orderProductService;
    @Override
    public Result unifiedOrder(Request<Order> request) throws TipsException {
        Order order = request.getData();
        if(EmptyUtil.isEmpty(order.getId())){
            return Result.failed("订单id不可为空");
        }
        OrderEntity orderEntity = orderService.load(order);
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderId(orderEntity.getId());
        List<OrderProductEntity> orderProductEntityList = orderProductService.list(orderProductEntity);
        if(EmptyUtil.isEmpty(orderProductEntityList)){
            return Result.failed("该订单无商品");
        }
        //此处应该计算价格


        try {
            // 2. 发起API调用（以支付能力下的统一收单交易创建接口为例）
            AlipayTradeCreateResponse response = Factory.Payment.Common().create("App",
                    order.getNum(), order.getPaidPrice(), order.getAppuserId());
            // 3. 处理响应或异常
            if ("10000".equals(response.code)) {
                return Result.successed("支付成功");
            } else {
                String errMsg = "支付失败，原因：" + response.msg + "，" + response.subMsg;
                LogUtil.errorLog(this,errMsg);
                return Result.failed("支付失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            String errMsg = "支付遭遇异常，原因：" + e.getMessage();
            LogUtil.errorLog(this,errMsg);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Result refund(Request<Order> request) throws TipsException {
        return null;
    }

    @Override
    public String payNotfiy(String requestBody) {
        return null;
    }
}
