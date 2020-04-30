package com.yihukurama.sysbase.controller;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 说明： 系统模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "系统回调接口", tags = "系统接口")
@RestController
@RequestMapping("/baichengfu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CallBackController {


    @Autowired
    IAppPublic iAppPublic;

    @ApiOperation(value = "微信订单付款", notes = "由微信支付回调订单ID")
    @RequestMapping(value = "/wxpay_goodsorder", method = RequestMethod.POST)
    public String wxpayGoodsOrder(@RequestBody Request<ProductEntity> request) throws Exception {


        return "";
    }
}
