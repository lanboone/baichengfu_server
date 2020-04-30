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
@ApiModel(value="订单商品表")
@Table(name="tb_order_product")
@Data
public class OrderProductEntity extends BaseEntity
{
	/**
	*商品图片
	**/
	@ApiModelProperty(value="商品图片")
	@Column(name="product_pic")
	private String productPic;
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
	*规格图片路径
	**/
	@ApiModelProperty(value="规格图片路径")
	@Column(name="picture_url")
	private String pictureUrl;
	/**
	*购买数量
	**/
	@ApiModelProperty(value="购买数量")
	@Column(name="count")
	private Integer count;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*app用户id
	**/
	@ApiModelProperty(value="app用户id")
	@Column(name="appuser_id")
	private String appuserId;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*快递单号
	**/
	@ApiModelProperty(value="快递单号")
	@Column(name="ems_cod")
	private String emsCod;
	/**
	*商品id
	**/
	@ApiModelProperty(value="商品id")
	@Column(name="product_id")
	private String productId;
	/**
	*子规格组合,分号分割，如红色;20x20;A
	**/
	@ApiModelProperty(value="子规格组合,分号分割，如红色;20x20;A")
	@Column(name="compose")
	private String compose;
	/**
	*商品价格
	**/
	@ApiModelProperty(value="商品价格")
	@Column(name="price")
	private String price;
	/**
	*商品简介
	**/
	@ApiModelProperty(value="商品简介")
	@Column(name="product_note")
	private String productNote;
	/**
	*市场价
	**/
	@ApiModelProperty(value="市场价")
	@Column(name="market_price")
	private String marketPrice;
	/**
	*状态 10待发货  20待收货  30待退款  40已退款  50已确认
	**/
	@ApiModelProperty(value="状态 10待发货  20待收货  30待退款  40已退款  50已确认")
	@Column(name="status")
	private Integer status;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
