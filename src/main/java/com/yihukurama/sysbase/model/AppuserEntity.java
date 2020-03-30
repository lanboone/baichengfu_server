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
 * 说明： APP用户表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="APP用户表")
@Table(name="tb_appuser")
public class AppuserEntity extends BaseEntity
{
	/**
	*是否限制登录 0否 1是
	**/
	@ApiModelProperty(value="是否限制登录 0否 1是")
	@Column(name="is_limit_login")
	private Integer isLimitLogin;
	/**
	*用户密码（MD5）
	**/
	@ApiModelProperty(value="用户密码（MD5）")
	@Column(name="user_password")
	private String userPassword;
	/**
	*微信号
	**/
	@ApiModelProperty(value="微信号")
	@Column(name="wechat_number")
	private String wechatNumber;
	/**
	*性别
	**/
	@ApiModelProperty(value="性别")
	@Column(name="gender")
	private String gender;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*用户名
	**/
	@ApiModelProperty(value="用户名")
	@Column(name="user_name")
	private String userName;
	/**
	*职业（装修师、设计师）
	**/
	@ApiModelProperty(value="职业（装修师、设计师）")
	@Column(name="profession")
	private String profession;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*身份证号
	**/
	@ApiModelProperty(value="身份证号")
	@Column(name="identity_number")
	private String identityNumber;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*地址id
	**/
	@ApiModelProperty(value="地址id")
	@Column(name="address_id")
	private String addressId;
	/**
	*app登录token
	**/
	@ApiModelProperty(value="app登录token")
	@Column(name="token")
	private String token;
	/**
	*是否首次登录 0否 1是
	**/
	@ApiModelProperty(value="是否首次登录 0否 1是")
	@Column(name="is_first_login")
	private Integer isFirstLogin;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*个人积分
	**/
	@ApiModelProperty(value="个人积分")
	@Column(name="integral")
	private Integer integral;
	/**
	*手机号
	**/
	@ApiModelProperty(value="手机号")
	@Column(name="phone_number")
	private String phoneNumber;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*qq号
	**/
	@ApiModelProperty(value="qq号")
	@Column(name="qq")
	private String qq;
	/**
	*年龄
	**/
	@ApiModelProperty(value="年龄")
	@Column(name="age")
	private Integer age;
	
	

	public Integer getIsLimitLogin(){
		return isLimitLogin;
	}

	public void setIsLimitLogin(Integer isLimitLogin){
		this.isLimitLogin = isLimitLogin;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getWechatNumber(){
		return wechatNumber;
	}

	public void setWechatNumber(String wechatNumber){
		this.wechatNumber = wechatNumber;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getProfession(){
		return profession;
	}

	public void setProfession(String profession){
		this.profession = profession;
	}

	public Date getOperateDate(){
		return operateDate;
	}

	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}

	public String getIdentityNumber(){
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber){
		this.identityNumber = identityNumber;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}

	public String getAddressId(){
		return addressId;
	}

	public void setAddressId(String addressId){
		this.addressId = addressId;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token = token;
	}

	public Integer getIsFirstLogin(){
		return isFirstLogin;
	}

	public void setIsFirstLogin(Integer isFirstLogin){
		this.isFirstLogin = isFirstLogin;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public Integer getIntegral(){
		return integral;
	}

	public void setIntegral(Integer integral){
		this.integral = integral;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
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

	public String getQq(){
		return qq;
	}

	public void setQq(String qq){
		this.qq = qq;
	}

	public Integer getAge(){
		return age;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	
	

	
	
}
