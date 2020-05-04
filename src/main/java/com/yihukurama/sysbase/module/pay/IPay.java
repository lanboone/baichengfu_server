package com.yihukurama.sysbase.module.pay;

import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IPay {

    public Result unifiedOrder(@RequestBody Request<Order> request) throws TipsException;
    public Result refund(Request<Order> request) throws TipsException;
    public String payNotfiy(String requestBody) throws TipsException;
}
