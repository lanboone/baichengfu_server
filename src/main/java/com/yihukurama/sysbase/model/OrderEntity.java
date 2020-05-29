package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
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
	 *运费
	 **/
	@ApiModelProperty(value="运费")
	@Column(name="freight")
	private BigDecimal freight;

	/**
	 *产生积分
	 **/
	@ApiModelProperty(value="产生积分")
	@Column(name="gen_point")
	private BigDecimal genPoint;

	/**
	 *消费积分
	 **/
	@ApiModelProperty(value="消费积分")
	@Column(name="consum_point")
	private BigDecimal consumPoint;


	/**
	 *发货时间
	 **/
	@ApiModelProperty(value="发货时间")
	@Column(name="send_time")
	private Date sendTime;


	/**
	 *支付时间
	 **/
	@ApiModelProperty(value="支付时间")
	@Column(name="pay_time")
	private Date payTime;


	/**
	 *用户上线id
	 **/
	@ApiModelProperty(value="用户上线id")
	@Column(name="appuser_parent_id")
	private String appuserParentId;


	/**
	 *收件人姓名
	 **/
	@ApiModelProperty(value="收件人姓名")
	@Column(name="receive_person")
	private String receivePerson;

	/**
	 *收件人电话
	 **/
	@ApiModelProperty(value="收件人电话")
	@Column(name="receive_phone")
	private String receivePhone;

	/**
	 *收件人地址
	 **/
	@ApiModelProperty(value="收件人地址")
	@Column(name="receive_address")
	private String receiveAddress;


	/**
	 *支付宝或微信的订单号
	 **/
	@ApiModelProperty(value="支付宝或微信的订单号")
	@Column(name="trade_no")
	private String tradeNo;


	/**
	 *订单来源，可存手机型号
	 **/
	@ApiModelProperty(value="订单来源，可存手机型号")
	@Column(name="origin")
	private String origin;

	/**
	*实付价格（待支付状态可修改）
	**/
	@ApiModelProperty(value="实付价格（待支付状态可修改）")
	@Column(name="paid_price")
	private BigDecimal paidPrice;
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
	*订单金额
	**/
	@ApiModelProperty(value="订单金额")
	@Column(name="order_price")
	private BigDecimal orderPrice;
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
	*装修师id
	**/
	@ApiModelProperty(value="装修师id")
	@Column(name="address_id")
	private String addressId;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="appuser_id")
	private String appuserId;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*商品id
	**/
	@ApiModelProperty(value="商品id")
	@Column(name="product_id")
	private String productId;
	/**
	*支付方式 10微信 20支付宝 30二维码
	**/
	@ApiModelProperty(value="支付方式 10微信 20支付宝 30二维码")
	@Column(name="pay_type")
	private Integer payType;
	/**
	*订单状态（10待支付、20待发货、30待收货、40待评价、50待退款、60已退款）
	**/
	@ApiModelProperty(value="订单状态（10待支付、20待发货、30待收货、40待评价、50待退款、60已退款）")
	@Column(name="status")
	private Integer status;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
