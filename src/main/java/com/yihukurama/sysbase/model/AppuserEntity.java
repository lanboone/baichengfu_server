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
 * 说明： APP用户表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="APP用户表")
@Table(name="tb_appuser")
@Data
public class AppuserEntity extends BaseEntity
{
	/**
	 *上线app用户id
	 **/
	@ApiModelProperty(value="上线app用户id")
	@Column(name="parent_id")
	private String parentId;
	/**
	 *个人专属邀请码
	 **/
	@ApiModelProperty(value="个人专属邀请码")
	@Column(name="personal_code")
	private String personalCode;


	/**
	 *app用户类型0普通用户,10设计师,20安装师傅
	 **/
	@ApiModelProperty(value="app用户类型0普通用户,10设计师,20安装师傅")
	@Column(name="type")
	private Integer type;
	/**
	 *app用户头像
	 **/
	@ApiModelProperty(value="app用户头像")
	@Column(name="head_url")
	private String headUrl;
	/**
	 *app用户昵称
	 **/
	@ApiModelProperty(value="app用户昵称")
	@Column(name="nick_name")
	private String nickName;
	/**
	*微信登录绑定的openid
	**/
	@ApiModelProperty(value="微信登录绑定的openid")
	@Column(name="wxapp_openid")
	private String wxappOpenid;
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
	*用户地址字符串
	**/
	@ApiModelProperty(value="用户地址字符串")
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
	
	

	
	
}
