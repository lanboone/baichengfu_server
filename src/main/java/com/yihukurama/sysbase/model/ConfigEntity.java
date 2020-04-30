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
 * 说明： 
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="")
@Table(name="sys_config")
@Data
public class ConfigEntity extends BaseEntity
{
	/**
	*set_by
	**/
	@ApiModelProperty(value="set_by")
	@Column(name="set_by")
	private String setBy;
	/**
	*set_time
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="set_time")
	private Date setTime;
	/**
	*value
	**/
	@ApiModelProperty(value="value")
	@Column(name="value")
	private String value;
	/**
	*variable
	**/
	@ApiModelProperty(value="variable")
	@Column(name="variable")
	private String variable;
	
	

	
	
}
