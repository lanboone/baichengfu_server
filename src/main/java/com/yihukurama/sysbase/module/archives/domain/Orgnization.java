package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.OrgnizationEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import lombok.Data;

import java.util.List;

/**
 * 说明： OrganizationEntity的领域对象
 * @author: ouyaokun
 * @date: Created in 17:10 2018/4/28
 * @modified: by autor in 17:10 2018/4/28
 */
@Data
public class Orgnization extends OrgnizationEntity {

    /**
     * 根节点的pid
     */
    public static final String PID_ROOT ="ROOT";
    /**
     * 机构下的子机构
     */
    List<Orgnization> child;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "text")
    @Override
    public String getText() {
        return super.getText();
    }
}
