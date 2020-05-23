package com.yihukurama.sysbase.module.admin.impl;

import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.controller.admin.dto.ManagerModifyDTO;
import com.yihukurama.sysbase.controller.admin.dto.ModifyPassWordDTO;
import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.model.ManagerprivilegeEntity;
import com.yihukurama.sysbase.model.PrivilegeEntity;
import com.yihukurama.sysbase.module.admin.IManager;
import com.yihukurama.sysbase.module.archives.domain.Manager;
import com.yihukurama.sysbase.module.archives.domain.ManagerPrivilege;
import com.yihukurama.sysbase.module.archives.domain.Privilege;
import com.yihukurama.sysbase.module.archives.service.domainservice.ManagerPrivilegeService;
import com.yihukurama.sysbase.module.archives.service.domainservice.ManagerService;
import com.yihukurama.sysbase.module.archives.service.domainservice.PrivilegeService;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: liyuan
 * @date: 2020/4/2 17:04
 * @description: 管理员服务
 */
@Service
public class ManagerServiceImpl implements IManager {

    @Autowired
    ManagerService managerService;

    @Autowired
    ManagerPrivilegeService managerPrivilegeService;

    @Autowired
    PrivilegeService privilegeService;

    @Override
    public Result adminLogin(Request<LoginDTO> request) throws TipsException {
        String managerName = request.getData().getManagerName();
        String password = request.getData().getPassword();

        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setSysName(managerName);
        List<ManagerEntity> manageNameList = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(manageNameList)) {
            return Result.failed(null, "用户不存在", -2);
        }

        managerEntity.setSysPassword(password);
        List<ManagerEntity> managerEntityList = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(managerEntityList)) {
            return Result.failed(null, "用户名或密码错误", -2);
        }
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        ManagerEntity managerSetToken = managerEntityList.get(0);
        managerSetToken.setToken(token);
        ManagerEntity managerSuc = managerService.update(managerSetToken);
        Manager loginManager = TransferUtils.transferEntity2Domain(managerSuc,Manager.class);

        //增加权限
        List<PrivilegeEntity> menuPrivilegeEntities = new ArrayList<>();
        List<PrivilegeEntity> productPrivilegeEntities = new ArrayList<>();
        ManagerprivilegeEntity managerPrivilege = new ManagerprivilegeEntity();
        managerPrivilege.setManagerId(managerSuc.getId());
        List<ManagerprivilegeEntity> managerprivilegeEntities =  managerPrivilegeService.list(managerPrivilege);
        if(!CollectionUtils.isEmpty(managerprivilegeEntities)){
            for (int i = 0; i < managerprivilegeEntities.size(); i++) {
                ManagerprivilegeEntity managerprivilegeEntity = managerprivilegeEntities.get(i);
                //获得权限
                String priId = managerprivilegeEntity.getPrivilegeId();
                PrivilegeEntity privilegeEntity = new PrivilegeEntity();
                privilegeEntity.setId(priId);
                privilegeEntity = privilegeService.load(privilegeEntity);
                if(privilegeEntity.getType() == Privilege.PRIVILEGE_TYPE_10){
                    menuPrivilegeEntities.add(privilegeEntity);
                }else if(privilegeEntity.getType() == Privilege.PRIVILEGE_TYPE_10){
                    productPrivilegeEntities.add(privilegeEntity);
                }
            }
        }
        loginManager.setProductPrivilegeEntities(productPrivilegeEntities);
        loginManager.setMenuPrivilegeEntities(menuPrivilegeEntities);

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
        if (!manageEntityFromDB.getSysPassword().equals(password)) {
            return Result.failed(null, "旧密码错误", -2);
        }
        String newPass = request.getData().getNewPassword();
        manageEntityFromDB.setSysPassword(newPass);
        ManagerEntity managerSuc = managerService.update(manageEntityFromDB);
        return Result.successed(managerSuc, "修改成功");
    }

    @Override
    public Result managerLoginByToken(String id, String token) throws TipsException {
        ManagerEntity managerEntity = new ManagerEntity();

        managerEntity.setId(id);
        managerEntity.setToken(token);

        List<ManagerEntity> managerEntities = managerService.list(managerEntity);
        if (CollectionUtils.isEmpty(managerEntities)) {
            //若为空，该token已失效
            return Result.failed(null, "该token已失效", -4);
        }
        ManagerEntity managerSuc = managerEntities.get(0);
        return Result.successed(managerSuc, "登录成功");
    }
}
