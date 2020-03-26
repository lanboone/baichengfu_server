package com.yihukurama.sysbase.module.app;

import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.Smstemplate;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.stereotype.Service;

/**
 * 说明： app公开服务
 * @author yihukurama
 * @date Created in 19:27 2020/3/26
 *       Modified by yihukurama in 19:27 2020/3/26
 */
public interface IAppPublic {
    /**
     * 说明： APP登录接口
     * @author yihukurama
     * @date Created in 19:35 2020/3/26
     *       Modified by yihukurama in 19:35 2020/3/26
     */
    Result appLogin(Request<Appuser> request);
    /**
     * 说明： app发送短信
     * @author yihukurama
     * @date Created in 19:35 2020/3/26
     *       Modified by yihukurama in 19:35 2020/3/26
     */
    Result appSendMsg(Request<Smstemplate> request);
    /**
     * 说明： app静默登录
     * @author yihukurama
     * @date Created in 19:37 2020/3/26
     *       Modified by yihukurama in 19:37 2020/3/26
     */
    Result appLoginByToken(Request<Appuser> request);

    /**
     * 说明： 注册
     * @author yihukurama
     * @date Created in 19:40 2020/3/26
     *       Modified by yihukurama in 19:40 2020/3/26
     */
    Result appRegist(Request<Appuser> request);


}
