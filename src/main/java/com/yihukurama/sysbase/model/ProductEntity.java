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
 * 说明： 商品表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="商品表")
@Table(name="tb_product")
@Data
public class ProductEntity extends BaseEntity
{
	/**
	*面积
	**/
	@ApiModelProperty(value="面积")
	@Column(name="area")
	private Integer area;
	/**
	*数量
	**/
	@ApiModelProperty(value="数量")
	@Column(name="quantity")
	private Integer quantity;
	/**
	*分类id
	**/
	@ApiModelProperty(value="分类id")
	@Column(name="categories_id")
	private String categoriesId;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*简介
	**/
	@ApiModelProperty(value="简介")
	@Column(name="profile")
	private String profile;
	/**
	*预付价
	**/
	@ApiModelProperty(value="预付价")
	@Column(name="prepaid_price")
	private Integer prepaidPrice;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*预付比例
	**/
	@ApiModelProperty(value="预付比例")
	@Column(name="prepaid_ratio")
	private String prepaidRatio;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*商品名
	**/
	@ApiModelProperty(value="商品名")
	@Column(name="product_name")
	private String productName;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*收藏数
	**/
	@ApiModelProperty(value="收藏数")
	@Column(name="favorite_number")
	private Integer favoriteNumber;
	/**
	*是否推荐到首页 0否 1是
	**/
	@ApiModelProperty(value="是否推荐到首页 0否 1是")
	@Column(name="is_recommend")
	private Integer isRecommend;
	/**
	*单位数量（39扇）
	**/
	@ApiModelProperty(value="单位数量（39扇）")
	@Column(name="unit_quantity")
	private String unitQuantity;
	/**
	*实付价
	**/
	@ApiModelProperty(value="实付价")
	@Column(name="actual_paid_price")
	private String actualPaidPrice;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*销量
	**/
	@ApiModelProperty(value="销量")
	@Column(name="sales_volume")
	private Integer salesVolume;
	
	

	
	
}
