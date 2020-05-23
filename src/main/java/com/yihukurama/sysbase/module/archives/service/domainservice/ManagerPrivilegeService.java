package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ManagerprivilegeEntity;
import com.yihukurama.sysbase.model.ProductStandardEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.sysbase.module.archives.domain.ManagerPrivilege;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerPrivilegeService extends CrudService<ManagerprivilegeEntity> {

    @Override
    public ManagerprivilegeEntity create(ManagerprivilegeEntity managerprivilegeEntity) throws TipsException {
        if (managerprivilegeEntity instanceof ManagerPrivilege){
            ManagerPrivilege managerPrivilege = (ManagerPrivilege) managerprivilegeEntity;

            //删除原权限
            ManagerprivilegeEntity oldPrivilege = new ManagerprivilegeEntity();
            oldPrivilege.setManagerId(managerprivilegeEntity.getManagerId());
            List<ManagerprivilegeEntity> oldPrivileges =  this.list(oldPrivilege);
            for (int i = 0; i < oldPrivileges.size(); i++) {
                this.remove(oldPrivileges.get(i));
            }

            List<ManagerprivilegeEntity> newPrivileges = managerPrivilege.getManagerprivilegeEntities();

            for (ManagerprivilegeEntity newPrivilege:newPrivileges
            ) {
                if(newPrivilege == null || newPrivilege.getManagerId() == null
                || newPrivilege.getPrivilegeId() == null){
                    throw new TipsException("创建权限时必须有用户id和权限id");
                }

            }
            return managerPrivilege;
        }
        return super.create(managerprivilegeEntity);
    }
}
