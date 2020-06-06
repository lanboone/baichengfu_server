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
 * 说明： 商品分析
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="商品分析")
@Table(name="tb_product_analyse")
@Data
public class ProductAnalyseEntity extends BaseEntity
{
	/**
	*详细分类id
	**/
	@ApiModelProperty(value="详细分类id")
	@Column(name="standard_id")
	private String standardId;
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
	*商品名
	**/
	@ApiModelProperty(value="商品名")
	@Column(name="product_name")
	private String productName;
	/**
	*类型,10 按商品，20 按商品详细分类
	**/
	@ApiModelProperty(value="类型,10 按商品，20 按商品详细分类")
	@Column(name="type")
	private Integer type;
	/**
	*商品id
	**/
	@ApiModelProperty(value="商品id")
	@Column(name="product_id")
	private String productId;
	/**
	*销售总额
	**/
	@ApiModelProperty(value="销售总额")
	@Column(name="sold_price_count")
	private String soldPriceCount;
	/**
	*详细分类名
	**/
	@ApiModelProperty(value="详细分类名")
	@Column(name="standard_name")
	private String standardName;
	/**
	*销售总数量
	**/
	@ApiModelProperty(value="销售总数量")
	@Column(name="sold_num_count")
	private Integer soldNumCount;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
