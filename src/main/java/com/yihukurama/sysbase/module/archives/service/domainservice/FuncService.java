package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.FuncMapper;
import com.yihukurama.sysbase.model.FuncEntity;
import com.yihukurama.sysbase.model.RoleprivilegeEntity;
import com.yihukurama.sysbase.module.archives.domain.Roleprivilege;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FuncService extends CrudService<FuncEntity> {
    @Autowired
    private RoleprivilegeService roleprivilegeService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    FuncMapper funcMapper;

    /**
     * 说明： 级联删除角色权限表
     * @author: ChenPeiLong
     * @date: Created in 9:13 2019/3/18
     * @modified: by ChenPeiLong in 9:13 2019/3/18
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int remove(FuncEntity funcEntity) throws TipsException {
        if(EmptyUtil.isEmpty(funcEntity.getId())){
            return 0;
        }
        RoleprivilegeEntity roleprivilegeEntity = new RoleprivilegeEntity();
        roleprivilegeEntity.setPrivilegeId(funcEntity.getId());
        roleprivilegeEntity.setType(Roleprivilege.QXLX_2);
        List<RoleprivilegeEntity> list = roleprivilegeService.list(roleprivilegeEntity);
        for (RoleprivilegeEntity entity : list) {
            roleprivilegeService.remove(entity);
        }
        return super.remove(funcEntity);
    }

    @Override
    public FuncEntity create(FuncEntity data) throws TipsException {
        data.setCode(UUID.randomUUID().toString().replaceAll("-",""));
        return super.create(data);
    }
}
