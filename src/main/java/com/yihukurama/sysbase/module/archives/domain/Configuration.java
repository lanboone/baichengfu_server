package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ConfigurationEntity;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;

/**
 * 说明： ConfigurationEntity的领域对象
 * @author: ouyaokun
 * @date: Created in 17:10 2018/4/28
 * @modified: by autor in 17:10 2018/4/28
 */
public class Configuration extends ConfigurationEntity {

    /**
     * 登录超时，单位秒
     */
    public static final String LOGIN_EXPIRETIME = "LOGIN_EXPIRETIME";

}
