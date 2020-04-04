package com.yihukurama.sysbase.module.app;

import com.yihukurama.sysbase.controller.app.dto.FocusDesignerDto;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

public interface IPerson {

    /**
     * 说明： 关注设计师
     * @author yihukurama
     * @date Created in 17:05 2020/4/4
     *       Modified by yihukurama in 17:05 2020/4/4
     */
    Result focusDesigner(Request<FocusDesignerDto> request) throws TipsException;
    /**
     * 说明： 取关设计师
     * @author yihukurama
     * @date Created in 17:05 2020/4/4
     *       Modified by yihukurama in 17:05 2020/4/4
     */
    Result unFocusDesigner(Request<FocusDesignerDto> request) throws TipsException;
}
