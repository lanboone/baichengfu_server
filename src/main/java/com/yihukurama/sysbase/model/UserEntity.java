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
 * 说明： 用户表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="用户表")
@Table(name="ts_user")
@Data
public class UserEntity extends com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.UserEntity
{
	/**
	*时间戳
	**/
	@ApiModelProperty(value="时间戳")
	@Column(name="time_stamp")
	private String timeStamp;
	/**
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="index_order")
	private Integer indexOrder;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*最后登录时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="last_login_date")
	private Date lastLoginDate;
	/**
	*用户token
	**/
	@ApiModelProperty(value="用户token")
	@Column(name="token")
	private String token;
	/**
	*所属机构id
	**/
	@ApiModelProperty(value="所属机构id")
	@Column(name="org_id")
	private String orgId;
	/**
	*联系方式
	**/
	@ApiModelProperty(value="联系方式")
	@Column(name="phone")
	private String phone;
	/**
	*账号
	**/
	@ApiModelProperty(value="账号")
	@Column(name="username")
	private String username;
	/**
	*账号状态 1正常 2禁用
	**/
	@ApiModelProperty(value="账号状态 1正常 2禁用")
	@Column(name="status")
	private Integer status;
	/**
	*用户最后登录时的ip地址
	**/
	@ApiModelProperty(value="用户最后登录时的ip地址")
	@Column(name="ip_addr")
	private String ipAddr;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*申请状态
	**/
	@ApiModelProperty(value="申请状态")
	@Column(name="request_status")
	private String requestStatus;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*真实姓名
	**/
	@ApiModelProperty(value="真实姓名")
	@Column(name="real_name")
	private String realName;
	/**
	*账号类型 1工作人员 2超级管理员
	**/
	@ApiModelProperty(value="账号类型 1工作人员 2超级管理员")
	@Column(name="type")
	private Integer type;
	/**
	*登录次数
	**/
	@ApiModelProperty(value="登录次数")
	@Column(name="login_count")
	private Integer loginCount;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*密码
	**/
	@ApiModelProperty(value="密码")
	@Column(name="password")
	private String password;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
