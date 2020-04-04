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
 * 说明： 装修师表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="装修师表")
@Table(name="tb_decorator")
@Data
public class DecoratorEntity extends BaseEntity
{
	/**
	*个人图片
	**/
	@ApiModelProperty(value="个人图片")
	@Column(name="personal_picture")
	private String personalPicture;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
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
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*预留字段1
	**/
	@ApiModelProperty(value="预留字段1")
	@Column(name="parameter1")
	private String parameter1;
	/**
	*装修师技能(布线、贴砖)
	**/
	@ApiModelProperty(value="装修师技能(布线、贴砖)")
	@Column(name="skills")
	private String skills;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="user_id")
	private String userId;
	/**
	*预留字段5
	**/
	@ApiModelProperty(value="预留字段5")
	@Column(name="parameter5")
	private Integer parameter5;
	/**
	*简介
	**/
	@ApiModelProperty(value="简介")
	@Column(name="introduction")
	private String introduction;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*预留字段4
	**/
	@ApiModelProperty(value="预留字段4")
	@Column(name="parameter4")
	private String parameter4;
	/**
	*预留字段3
	**/
	@ApiModelProperty(value="预留字段3")
	@Column(name="parameter3")
	private String parameter3;
	/**
	*预留字段2
	**/
	@ApiModelProperty(value="预留字段2")
	@Column(name="parameter2")
	private String parameter2;
	
	

	
	
}
