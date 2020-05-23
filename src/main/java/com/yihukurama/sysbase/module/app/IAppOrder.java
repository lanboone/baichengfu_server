package com.yihukurama.sysbase.module.app;

import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

public interface IAppOrder {
    /**
     * 确认订单收货
     * @param request
     * @return
     */
    Result confirmOrder(Request<OrderEntity> request) throws TipsException;
}
