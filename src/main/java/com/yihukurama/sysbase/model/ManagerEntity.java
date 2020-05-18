package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.sysbase.handle.Md5Util;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明： 管理员表
 *
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value = "管理员表")
@Table(name = "tb_manager")
@Data
public class ManagerEntity extends BaseEntity {

    /**
     * 头像地址
     **/
    @ApiModelProperty(value = "头像地址")
    @Column(name = "head_url")
    private String headUrl;

    /**
     * 系统身份
     **/
    @ApiModelProperty(value = "系统身份")
    @Column(name = "sys_Identity")
    private String sysIdentity;
    /**
     * 最后修改人id
     **/
    @ApiModelProperty(value = "最后修改人id")
    @Column(name = "operator_id")
    private String operatorId;
    /**
     * 最后修改日期
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "operate_date")
    private Date operateDate;
    /**
     * 创建人id
     **/
    @ApiModelProperty(value = "创建人id")
    @Column(name = "creater_id")
    private String createrId;
    /**
     * 分销订单id列表
     **/
    @ApiModelProperty(value = "分销订单id列表")
    @Column(name = "distribution")
    private String distribution;
    /**
     * 管理员手机号
     **/
    @ApiModelProperty(value = "管理员手机号")
    @Column(name = "sys_phone")
    private String sysPhone;
    /**
     * 删除状态 0正常 1删除
     **/
    @ApiModelProperty(value = "删除状态 0正常 1删除")
    @Column(name = "is_delete")
    private Integer isDelete;
    /**
     * 预留字段1
     **/
    @ApiModelProperty(value = "预留字段1")
    @Column(name = "parameter1")
    private String parameter1;
    /**
     * 管理员名称
     **/
    @ApiModelProperty(value = "管理员名称")
    @Column(name = "sys_name")
    private String sysName;
    /**
     * 操作权限id列表
     **/
    @ApiModelProperty(value = "操作权限id列表")
    @Column(name = "permission_list")
    private String permissionList;
    /**
     * 预留字段5
     **/
    @ApiModelProperty(value = "预留字段5")
    @Column(name = "parameter5")
    private Integer parameter5;
    /**
     * 创建时间
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;
    /**
     * 预留字段4
     **/
    @ApiModelProperty(value = "预留字段4")
    @Column(name = "parameter4")
    private String parameter4;
    /**
     * 管理员密码
     **/
    @ApiModelProperty(value = "管理员密码")
    @Column(name = "sys_password")
    private String sysPassword;
    /**
     * 预留字段3
     **/
    @ApiModelProperty(value = "预留字段3")
    @Column(name = "parameter3")
    private String parameter3;
    /**
     * 预留字段2
     **/
    @ApiModelProperty(value = "预留字段2")
    @Column(name = "parameter2")
    private String parameter2;

    /**
     * 登录token
     **/
    @ApiModelProperty(value = "登录token")
    @Column(name = "token")
    private String token;
}
