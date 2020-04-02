package com.yihukurama.sysbase.module.admin.impl;

import com.yihukurama.sysbase.handle.Md5Util;
import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.module.admin.Manager;
import com.yihukurama.sysbase.module.archives.service.domainservice.ManagerService;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: liyuan
 * @date: 2020/4/2 17:04
 * @description: 管理员服务
 */
@Service
public class ManagerServiceImpl implements Manager {

    @Autowired
    ManagerService managerService;

    @Override
    public Result adminLogin(Request<LoginDTO> request) throws TipsException {
        String managerName = request.getData().getManagerName();
        String password = request.getData().getPassword();
        String md5Pass = Md5Util.getMD5(password);

        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setSysName(managerName);
        managerEntity.setSysPassword(md5Pass);
        List<ManagerEntity> managerEntityList = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(managerEntityList)) {
            return Result.failed(null, "用户名或密码错误", -2);
        }
        ManagerEntity managerSuc = managerEntityList.get(0);
        return Result.successed(managerSuc, "登录成功");
    }
}
