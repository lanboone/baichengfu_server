package com.yihukurama.sysbase.module.archives.service;


import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

/**
 * @Description: 系统服务
 * @Author: dengshuai
 * @Date: Created in 17:56 2018/1/16
 * @Modified: by autor in 17:56 2018/1/16
 */
public interface ISystem {

    /**
     * 说明： 修改密码
     * @author: ouyaokun
     * @date: Created in 15:49 2018/12/12
     * @modified: by autor in 15:49 2018/12/12
     * @param request 原密码 新密码
     * @return 修改是否成功
     */
    Result changePassword(Request<User> request) throws TipsException;

    /**
     * 登出
     * @param request
     * @return
     * @throws TipsException
     */
    Result logout(Request<User> request) throws TipsException;
}
