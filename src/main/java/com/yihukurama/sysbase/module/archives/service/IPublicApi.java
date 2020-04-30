package com.yihukurama.sysbase.module.archives.service;


import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

/**
 * 说明： 公共api
 * @author: ouyaokun
 * @date: Created in 16:56 2018/12/11
 * @modified: by autor in 16:56 2018/12/11
 */
public interface IPublicApi {


    /**
     * 说明： 登录
     * @author yihukurama
     * @date Created in 9:51 2020/2/5
     *       Modified by yihukurama in 9:51 2020/2/5
     */
    Result login(Request<User> request) throws TipsException;

    /**
     * 说明： 判断是否已登录
     * @author yihukurama
     * @date Created in 17:00 2020/2/4
     *       Modified by yihukurama in 17:00 2020/2/4
     */
    Result isLogin(Request<User> request);

}
