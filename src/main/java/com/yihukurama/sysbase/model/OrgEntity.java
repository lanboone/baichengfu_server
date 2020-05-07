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
@Table(name="ts_org")
@Data
public class OrgEntity extends BaseEntity
{

	/**
	 *快递单号
	 **/
	@ApiModelProperty(value="快递单号")
	@Column(name="ems_cod")
	private String emsCod;

	/**
	 *快递100要求存入的快递公司编码
	 **/
	@ApiModelProperty(value="快递100要求存入的快递公司编码")
	@Column(name="com")
	private String com;

	/**
	*机构编码
	**/
	@ApiModelProperty(value="机构编码")
	@Column(name="code")
	private String code;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*机构所在地详细地址
	**/
	@ApiModelProperty(value="机构所在地详细地址")
	@Column(name="address")
	private String address;
	/**
	*最后操作人id
	**/
	@ApiModelProperty(value="最后操作人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="index_order")
	private Integer indexOrder;
	/**
	*最后操作时间
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
	*机构负责人id
	**/
	@ApiModelProperty(value="机构负责人id")
	@Column(name="principal_id")
	private String principalId;
	/**
	*机构类型 
	**/
	@ApiModelProperty(value="机构类型 ")
	@Column(name="type")
	private Integer type;
	/**
	*机构路径，父机构为root
	**/
	@ApiModelProperty(value="机构路径，父机构为root")
	@Column(name="path")
	private String path;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*机构负责人名
	**/
	@ApiModelProperty(value="机构负责人名")
	@Column(name="principal")
	private String principal;
	/**
	*机构名称
	**/
	@ApiModelProperty(value="机构名称")
	@Column(name="text")
	private String text;
	/**
	*联系电话
	**/
	@ApiModelProperty(value="联系电话")
	@Column(name="tel")
	private String tel;
	/**
	*父机构id
	**/
	@ApiModelProperty(value="父机构id")
	@Column(name="p_id")
	private String pId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
