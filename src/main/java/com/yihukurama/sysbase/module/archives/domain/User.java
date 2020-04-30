package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.FuncEntity;
import com.yihukurama.sysbase.model.MenuEntity;
import com.yihukurama.sysbase.model.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class User extends UserEntity {

    /**
     * 正常账号状态: 正常
     */
    public static final Integer STATUS_1 = 1;

    /**
     * 正常账号状态: 禁用
     */
    public static final Integer STATUS_2 = 2;


    private List<MenuEntity> menus;
    private List<FuncEntity> funcs;
    private String token;
    private String currentAuthority;
    /**
     * 重置密码时必须传的参数
     */
    private Boolean resetPwd;

    /**
     * 登录成功的secret
     */
    private String secret;

}
