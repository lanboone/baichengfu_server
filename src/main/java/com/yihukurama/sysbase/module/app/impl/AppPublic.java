package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.Smstemplate;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 说明： APP公开服务
 * @author yihukurama
 * @date Created in 19:43 2020/3/26
 *       Modified by yihukurama in 19:43 2020/3/26
 */
@Service
public class AppPublic implements IAppPublic {
    @Override
    public Result appLogin(Request<Appuser> request) {
        return null;
    }

    @Override
    public Result appSendMsg(Request<Smstemplate> request) {
        return null;
    }

    @Override
    public Result appLoginByToken(Request<Appuser> request) {
        return null;
    }

    @Override
    public Result appRegist(Request<Appuser> request) {
        return null;
    }
}
