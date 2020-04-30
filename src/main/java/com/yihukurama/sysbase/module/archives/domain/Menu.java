package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.MenuEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class Menu extends MenuEntity {
    /**
     * 说明：根菜单的父id
     * @author: ChenPeiLong
     * @date: Created in 11:14 2019/3/23
     * @modified: by ChenPeiLong in 11:14 2019/3/23
     */
    public static final String ROOTPARENTID = "root";

    private List<Menu> children;
    private Boolean isLeaf;

    private String likeusername;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "text")
    public String getLikeusername() {
        return likeusername;
    }
}
