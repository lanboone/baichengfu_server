package com.yihukurama.sysbase.controller.app;

import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.pay.IPay;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 说明： 阿里支付业务接口
 * @author yihukurama
 * @date Created in 18:13 2020/5/3
 *       Modified by yihukurama in 18:13 2020/5/3
 */
@Api(value = "支付宝支付", tags = "支付接口")
@RestController
@RequestMapping("/ali/pay")
public class AlliPayController {


    @Qualifier("AliPayService")
    IPay iPay;

    @ApiOperation(httpMethod = "POST", value = "阿里支付下单接口", notes = "阿里支付下单接口")
    @RequestMapping(value = "/unified_order")
    public Result unifiedOrder(@RequestBody Request<Order> request) throws TipsException {
        Order order = request.getData();
        if(EmptyUtil.isEmpty(order.getId())){
            return Result.failed("订单id不可为空");
        }
//        aliSdkInit.init();
        return iPay.unifiedOrder(request);
    }


    @ApiOperation(httpMethod = "POST", value = "阿里支付申请退款接口", notes = "阿里支付申请退款接口")
    @RequestMapping(value = "/refund")
    public Result refund(@RequestBody Request<Order> request) throws TipsException {
        Order order = request.getData();
        if(EmptyUtil.isEmpty(order.getId())){
            return Result.failed("订单id不可为空");
        }

        return iPay.refund(request);
    }

    @ApiOperation(httpMethod = "GET", value = "阿里服务器支付通知接口", notes = "阿里服务器支付通知接口 \n\r")
    @RequestMapping(value = "/pay_notify", produces = "text/plain;charset=UTF-8")
    public String payNotfiy(@RequestBody(required = true) String requestBody) throws TipsException {

        return iPay.payNotfiy(requestBody);
    }


}
