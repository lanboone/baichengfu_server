package com.yihukurama.sysbase.module.admin;

import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.controller.admin.dto.ManagerModifyDTO;
import com.yihukurama.sysbase.controller.admin.dto.ModifyPassWordDTO;
import com.yihukurama.sysbase.controller.admin.dto.TokenLoginDTO;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

/**
 * @author: liyuan
 * @date: 2020/4/2 17:03
 * @description: 管理员相关服务
 */
public interface IManager {

    /**
     * 管理后台登录接口
     *
     * @param request
     * @return
     * @throws TipsException
     */
    Result adminLogin(Request<LoginDTO> request) throws TipsException;

    /**
     * 管理员修改用户名和手机号的接口
     *
     * @param request
     * @return
     * @throws TipsException
     */
    Result modifyNameAndPhone(Request<ManagerModifyDTO> request) throws TipsException;

    /**
     * 修改密码接口
     *
     * @param request
     * @return
     * @throws TipsException
     */
    Result modifyPassWord(Request<ModifyPassWordDTO> request) throws TipsException;

    /**
     * token登录
     * @return
     */
    Result managerLoginByToken(String id, String token) throws TipsException;
}
