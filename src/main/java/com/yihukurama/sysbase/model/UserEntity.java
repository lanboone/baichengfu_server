package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
	
	

	public String getTimeStamp(){
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}

	public Integer getIndexOrder(){
		return indexOrder;
	}

	public void setIndexOrder(Integer indexOrder){
		this.indexOrder = indexOrder;
	}

	public Date getOperateDate(){
		return operateDate;
	}

	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}

	public Date getLastLoginDate(){
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate){
		this.lastLoginDate = lastLoginDate;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getOrgId(){
		return orgId;
	}

	public void setOrgId(String orgId){
		this.orgId = orgId;
	}

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public String getIpAddr(){
		return ipAddr;
	}

	public void setIpAddr(String ipAddr){
		this.ipAddr = ipAddr;
	}

	public String getNote(){
		return note;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getRequestStatus(){
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus){
		this.requestStatus = requestStatus;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public String getRealName(){
		return realName;
	}

	public void setRealName(String realName){
		this.realName = realName;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getLoginCount(){
		return loginCount;
	}

	public void setLoginCount(Integer loginCount){
		this.loginCount = loginCount;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
