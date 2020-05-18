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
 * 说明： 定制订单表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="定制订单表")
@Table(name="tb_custom_order")
@Data
public class CustomOrderEntity extends BaseEntity
{
	/**
	*快递100要求存入的快递公司编码
	**/
	@ApiModelProperty(value="快递100要求存入的快递公司编码")
	@Column(name="com")
	private String com;
	/**
	*标题
	**/
	@ApiModelProperty(value="标题")
	@Column(name="title")
	private String title;
	/**
	*订单号
	**/
	@ApiModelProperty(value="订单号")
	@Column(name="num")
	private String num;
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
	*收件人姓名
	**/
	@ApiModelProperty(value="收件人姓名")
	@Column(name="receive_person")
	private String receivePerson;
	/**
	*图片
	**/
	@ApiModelProperty(value="图片")
	@Column(name="pic")
	private String pic;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*数量
	**/
	@ApiModelProperty(value="数量")
	@Column(name="count")
	private Integer count;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="appuser_id")
	private String appuserId;
	/**
	*装修师id
	**/
	@ApiModelProperty(value="装修师id")
	@Column(name="master_id")
	private String masterId;
	/**
	*内容步骤富文本
	**/
	@ApiModelProperty(value="内容步骤富文本")
	@Column(name="content")
	private String content;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*收件地址
	**/
	@ApiModelProperty(value="收件地址")
	@Column(name="receive_address")
	private String receiveAddress;
	/**
	*收件人电话
	**/
	@ApiModelProperty(value="收件人电话")
	@Column(name="receive_phone")
	private String receivePhone;
	/**
	*快递单号
	**/
	@ApiModelProperty(value="快递单号")
	@Column(name="ems_cod")
	private String emsCod;
	/**
	*价格
	**/
	@ApiModelProperty(value="价格")
	@Column(name="price")
	private String price;
	/**
	*特色
	**/
	@ApiModelProperty(value="特色")
	@Column(name="feature")
	private String feature;
	/**
	*专享
	**/
	@ApiModelProperty(value="专享")
	@Column(name="exclusive")
	private String exclusive;
	/**
	*订单状态（10待确认、20已确认）
	**/
	@ApiModelProperty(value="订单状态（10待确认、20已确认）")
	@Column(name="status")
	private Integer status;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
