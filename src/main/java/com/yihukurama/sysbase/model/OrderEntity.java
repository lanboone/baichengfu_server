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
 * 说明： 订单表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="订单表")
@Table(name="tb_order")
@Data
public class OrderEntity extends BaseEntity
{
	/**
	*实付价格（待支付状态可修改）
	**/
	@ApiModelProperty(value="实付价格（待支付状态可修改）")
	@Column(name="paid_price")
	private String paidPrice;
	/**
	*发货时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="delivery_time")
	private Date deliveryTime;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*装修师id
	**/
	@ApiModelProperty(value="装修师id")
	@Column(name="decorator_id")
	private String decoratorId;
	/**
	*收货人地址
	**/
	@ApiModelProperty(value="收货人地址")
	@Column(name="consignee_address")
	private String consigneeAddress;
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
	*退货人电话
	**/
	@ApiModelProperty(value="退货人电话")
	@Column(name="returne_phone")
	private String returnePhone;
	/**
	*收货人电话
	**/
	@ApiModelProperty(value="收货人电话")
	@Column(name="consignee_phone")
	private String consigneePhone;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="user_id")
	private String userId;
	/**
	*商品id
	**/
	@ApiModelProperty(value="商品id")
	@Column(name="product_id")
	private String productId;
	/**
	*退货地址
	**/
	@ApiModelProperty(value="退货地址")
	@Column(name="return_address")
	private String returnAddress;
	/**
	*订单状态（待支付、待发货、已发货、已收货、待退款、已同意退款、已退款）
	**/
	@ApiModelProperty(value="订单状态（待支付、待发货、已发货、已收货、待退款、已同意退款、已退款）")
	@Column(name="order_type")
	private String orderType;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
