package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.RoleprivilegeMapper;
import com.yihukurama.sysbase.model.RoleEntity;
import com.yihukurama.sysbase.model.RoleprivilegeEntity;
import com.yihukurama.sysbase.module.archives.domain.Role;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService extends CrudService<RoleEntity> {

    @Resource
    private RoleprivilegeMapper roleprivilegeMapper;

    @Autowired
    private RoleprivilegeService roleprivilegeService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RoleEntity create(RoleEntity roleEntity) throws TipsException {
        RoleEntity roleEntity1 = super.create(roleEntity);
        if(roleEntity instanceof Role){
            Role role = (Role) roleEntity;
            List<String> privilegeIds = role.getPrivilegeIds();
            String roleId = role.getRoleId();
            if(privilegeIds!=null){
                for (String privilegeId : privilegeIds) {
                    RoleprivilegeEntity entity = new RoleprivilegeEntity();
                    entity.setRoleId(roleId);
                    entity.setPrivilegeId(privilegeId);
                    roleprivilegeService.create(entity);
                }
            }
            return roleEntity1;
        }
       throw new TipsException("参数有误！");
    }


}
