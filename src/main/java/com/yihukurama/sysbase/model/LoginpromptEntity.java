package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: liyuan
 * @date: 2020/4/8 22:14
 * @description: 登录提示表
 */
@ApiModel(value = "登录提示表")
@Table(name = "tb_login_prompt")
@Data
public class LoginpromptEntity extends BaseEntity {



    /**
     * app用户id
     **/
    @ApiModelProperty(value = "app用户id")
    @Column(name = "add_person_id")
    private String addPersonId;

    /**
     * 添加人名称(app用户名)
     **/
    @ApiModelProperty(value = "添加人名称(app用户名)")
    @Column(name = "add_person_name")
    private String addPersonName;

    /**
     * 备注
     **/
    @ApiModelProperty(value = "备注")
    @Column(name = "remark")
    private String remark;

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
    @ApiModelProperty(value = "创建人id(管理员id)")
    @Column(name = "creater_id")
    private String createrId;
    /**
     * 删除状态 0正常 1删除
     **/
    @ApiModelProperty(value = "删除状态 0正常 1删除")
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;

}
