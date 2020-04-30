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
 * 说明： app用户关注设计师的关联表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="app用户关注设计师的关联表")
@Table(name="tb_appuser_designer")
@Data
public class AppuserDesignerEntity extends BaseEntity
{
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
	*设计师id
	**/
	@ApiModelProperty(value="设计师id")
	@Column(name="designer_id")
	private String designerId;
	/**
	*设计师头像
	**/
	@ApiModelProperty(value="设计师头像")
	@Column(name="head_url")
	private String headUrl;
	/**
	*荣耀值
	**/
	@ApiModelProperty(value="荣耀值")
	@Column(name="glory_value")
	private Integer gloryValue;
	/**
	*app用户id
	**/
	@ApiModelProperty(value="app用户id")
	@Column(name="appuser_id")
	private String appuserId;
	/**
	*设计师昵称
	**/
	@ApiModelProperty(value="设计师昵称")
	@Column(name="nick_name")
	private String nickName;
	/**
	*设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;
	**/
	@ApiModelProperty(value="设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;")
	@Column(name="style")
	private String style;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
