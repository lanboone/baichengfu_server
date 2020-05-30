package com.yihukurama.sysbase.module.im;

import com.yihukurama.sysbase.module.archives.domain.AppuserMsg;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

public interface IMqtt {

    Result sendMsg(Request<AppuserMsg> request) throws TipsException;
}
