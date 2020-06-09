package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Appuser extends AppuserEntity {


    public static final int CREATE_ORIGN_10 = 10;

    /**
     * 创建时来源  10 后台创建
     */
    @ApiModelProperty(value="创建时来源  10 后台创建")
    private Integer createOrign;

    public static final int REGIST_TYPE_10 = 10;

    public static final int REGIST_TYPE_20 = 20;

    /**
     * 注册时的类型  10 qq注册   20微信注册
     */
    @ApiModelProperty(value="注册时的类型  10 qq注册   20微信注册")
    private Integer registType;
    /**
     * 验证码
     */
    @ApiModelProperty(value="验证码")
    private String checkCode;
}
