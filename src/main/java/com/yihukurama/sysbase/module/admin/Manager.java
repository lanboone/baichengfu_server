package com.yihukurama.sysbase.module.admin;
import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
/**
 * @author: liyuan
 * @date: 2020/4/2 17:03
 * @description: 管理员相关服务
 */
public interface Manager {

    /**
     * 管理后台登录接口
     * @param request
     * @return
     * @throws TipsException
     */
    Result adminLogin(Request<LoginDTO> request) throws TipsException;

}
