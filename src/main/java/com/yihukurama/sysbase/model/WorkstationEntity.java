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
@Table(name="ts_workstation")
@Data
public class WorkstationEntity extends BaseEntity
{
	/**
	*联系人
	**/
	@ApiModelProperty(value="联系人")
	@Column(name="contact_name")
	private String contactName;
	/**
	*网点编码
	**/
	@ApiModelProperty(value="网点编码")
	@Column(name="code")
	private String code;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*网点详细地址
	**/
	@ApiModelProperty(value="网点详细地址")
	@Column(name="address")
	private String address;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
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
	*删除状态,0正常,1删除
	**/
	@ApiModelProperty(value="删除状态,0正常,1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*网点所属机构id
	**/
	@ApiModelProperty(value="网点所属机构id")
	@Column(name="org_id")
	private String orgId;
	/**
	*网点名称
	**/
	@ApiModelProperty(value="网点名称")
	@Column(name="text")
	private String text;
	/**
	*网点联系电话
	**/
	@ApiModelProperty(value="网点联系电话")
	@Column(name="tel")
	private String tel;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
