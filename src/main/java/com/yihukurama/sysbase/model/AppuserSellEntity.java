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
 * 说明： 用户分销表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="用户分销表")
@Table(name="tb_appuser_sell")
@Data
public class AppuserSellEntity extends BaseEntity
{
	/**
	*分销单单号
	**/
	@ApiModelProperty(value="分销单单号")
	@Column(name="num")
	private String num;
	/**
	*关联的订单商品id
	**/
	@ApiModelProperty(value="关联的订单商品id")
	@Column(name="order_product_id")
	private String orderProductId;
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
	*下单用户昵称
	**/
	@ApiModelProperty(value="下单用户昵称")
	@Column(name="buyer_name")
	private String buyerName;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*下单用户id
	**/
	@ApiModelProperty(value="下单用户id")
	@Column(name="buyer_id")
	private String buyerId;
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
	*分销获得的积分
	**/
	@ApiModelProperty(value="分销获得的积分")
	@Column(name="point")
	private Integer point;
	/**
	*订单商品id
	**/
	@ApiModelProperty(value="订单商品id")
	@Column(name="product_id")
	private String productId;
	/**
	*商品价格
	**/
	@ApiModelProperty(value="商品价格")
	@Column(name="price")
	private String price;
	/**
	*付款方订单号
	**/
	@ApiModelProperty(value="付款方订单号")
	@Column(name="order_num")
	private String orderNum;
	/**
	*付款方式
	**/
	@ApiModelProperty(value="付款方式")
	@Column(name="pay_type")
	private Integer payType;
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
