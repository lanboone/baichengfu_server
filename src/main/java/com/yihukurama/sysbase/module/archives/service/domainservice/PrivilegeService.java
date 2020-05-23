package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.PrivilegeEntity;
import com.yihukurama.sysbase.model.PrivilegeEntity;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 说明： Privilege的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class PrivilegeService extends CrudService<PrivilegeEntity>{

    /**
     * 创建菜单时生成code
     * @param data
     * @return
     * @throws TipsException
     */
    @Override
    public PrivilegeEntity create(PrivilegeEntity data) throws TipsException {
        data.setCode(UUID.randomUUID().toString().replaceAll("-",""));
        return super.create(data);
    }


}
