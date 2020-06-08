package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.module.archives.domain.Manager;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.businessservice.impl.SecurityService;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： Manager的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class ManagerService extends CrudService<ManagerEntity>{

    @Autowired
    SecurityService securityService;

    @Override
    public ManagerEntity update(ManagerEntity managerEntity) throws TipsException {
        if(managerEntity instanceof Manager){
            if(managerEntity.getSysPassword()!=null) {
                String encryptPwd = securityService.pwdEncrypt(managerEntity.getSysPassword());
                managerEntity.setSysPassword(encryptPwd);
            }

        }

        return super.update(managerEntity);
    }
}
