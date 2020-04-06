package com.yihukurama.sysbase.module.admin.impl;

import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.controller.admin.dto.ManagerModifyDTO;
import com.yihukurama.sysbase.controller.admin.dto.ModifyPassWordDTO;
import com.yihukurama.sysbase.handle.Md5Util;
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
        List<ManagerEntity> manageNameList = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(manageNameList)) {
            return Result.failed(null, "用户不存在", -2);
        }
        managerEntity.setSysPassword(md5Pass);
        List<ManagerEntity> managerEntityList = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(managerEntityList)) {
            return Result.failed(null, "用户名或密码错误", -2);
        }
        ManagerEntity managerSuc = managerEntityList.get(0);
        return Result.successed(managerSuc, "登录成功");
    }

    @Override
    public Result modifyNameAndPhone(Request<ManagerModifyDTO> request) throws TipsException {
        ManagerEntity managerEntity = new ManagerEntity();
        // 用户名是否已经被其他人使用
        String managerName = request.getData().getManagerName();
        ManagerEntity managerNameEntity = new ManagerEntity();
        managerNameEntity.setSysName(managerName);
        if (!CollectionUtils.isEmpty(managerService.list(managerNameEntity))) {
            return Result.failed(null, "此用户名已经存在，请更换其他用户名", -2);
        }

        String id = request.getData().getId();
        managerEntity.setId(id);
        // id是否存在
        ManagerEntity manageEntityFromDB = managerService.load(managerEntity);
        if (manageEntityFromDB == null) {
            return Result.failed(null, "此id的用户不存在,id is " + id, -2);
        }
        // 修改用户名
        manageEntityFromDB.setSysName(managerName);
        // 修改对应id的用户名和手机号
        String phone = request.getData().getSysPhone();
        manageEntityFromDB.setSysPhone(phone);
        ManagerEntity managerSuc = managerService.update(manageEntityFromDB);
        return Result.successed(managerSuc, "修改成功");
    }

    @Override
    public Result modifyPassWord(Request<ModifyPassWordDTO> request) throws TipsException {
        ManagerEntity managerEntity = new ManagerEntity();
        String id = request.getData().getId();
        managerEntity.setId(id);
        // id是否存在
        ManagerEntity manageEntityFromDB = managerService.load(managerEntity);
        if (manageEntityFromDB == null) {
            return Result.failed(null, "此id的用户不存在,id is " + id, -2);
        }
        // 旧密码是否正确
        String password = request.getData().getOldPassword();
        String md5Pass = Md5Util.getMD5(password);
        if (!manageEntityFromDB.getSysPassword().equals(md5Pass)) {
            return Result.failed(null, "旧密码错误", -2);
        }
        String newPass = request.getData().getNewPassword();
        String newMd5Pass = Md5Util.getMD5(newPass);
        manageEntityFromDB.setSysPassword(newMd5Pass);
        ManagerEntity managerSuc = managerService.update(manageEntityFromDB);
        return Result.successed(managerSuc, "修改成功");
    }
}
