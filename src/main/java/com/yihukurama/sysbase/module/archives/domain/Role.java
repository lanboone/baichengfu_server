package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.RoleEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Role extends RoleEntity {

    String secret;

    String roleId;
    List<String> privilegeIds;

    String userId;


    String likename;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "text")
    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        this.likename = likename;
    }
}
