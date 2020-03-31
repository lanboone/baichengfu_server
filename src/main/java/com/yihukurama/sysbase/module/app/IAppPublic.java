package com.yihukurama.sysbase.module.app;

import com.yihukurama.sysbase.controller.app.dto.ForgetPwdDto;
import com.yihukurama.sysbase.controller.app.dto.LoginDto;
import com.yihukurama.sysbase.controller.app.dto.RegistDto;
import com.yihukurama.sysbase.controller.app.dto.TokenLoginDto;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.Smstemplate;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

/**
 * 说明： app公开服务
 * @author yihukurama
 * @date Created in 19:27 2020/3/26
 *       Modified by yihukurama in 19:27 2020/3/26
 */
public interface IAppPublic {


    /**
     * 说明： 重置密码
     * @author yihukurama
     * @date Created in 23:06 2020/3/30
     *       Modified by yihukurama in 23:06 2020/3/30
     */
    Result forgetPwd(Request<ForgetPwdDto> request) throws TipsException;


    /**
     * 说明： APP登录接口
     * @author yihukurama
     * @date Created in 19:35 2020/3/26
     *       Modified by yihukurama in 19:35 2020/3/26
     */
    Result appLogin(Request<LoginDto> request) throws TipsException;
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
    Result appLoginByToken(Request<TokenLoginDto> request) throws TipsException;

    /**
     * 说明： 注册
     * @author yihukurama
     * @date Created in 19:40 2020/3/26
     *       Modified by yihukurama in 19:40 2020/3/26
     */
    Result appRegist(Request<RegistDto> request) throws TipsException;

    /**
     * 说明： 发送短信验证码
     * @author yihukurama
     * @date Created in 13:35 2020/3/27
     *       Modified by yihukurama in 13:35 2020/3/27
     */
    Result sendCode(Request<String> request);

    /**
     * 说明： 校验短信验证码
     * @author yihukurama
     * @date Created in 13:36 2020/3/27
     *       Modified by yihukurama in 13:36 2020/3/27
     */
    Result checkCode(Request<Appuser> request);

}
