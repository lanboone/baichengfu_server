package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.model.PrivilegeEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import lombok.Data;

import java.util.List;

/**
 * @author: liyuan
 * @date: 2020/4/2 18:58
 * @description: 管理员
 */
@Data
public class Manager extends ManagerEntity {


    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "sys_name")
    @Override
    public String getSysName() {
        return super.getSysName();
    }

    /**
     * 登录时返回的菜单权限列表
     */
    List<PrivilegeEntity> menuPrivilegeEntities;
    /**
     * 登录时返回的商品分类权限列表
     */
    List<PrivilegeEntity> productPrivilegeEntities;

}
