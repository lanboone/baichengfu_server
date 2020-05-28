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
 * 说明： 商品分类表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="商品分类表")
@Table(name="tb_product_categories")
@Data
public class ProductCategoriesEntity extends BaseEntity
{


	/**
	 *排序
	 **/
	@ApiModelProperty(value="排序")
	@Column(name="index_order")
	private Integer indexOrder;


	/**
	 *创建人昵称
	 **/
	@ApiModelProperty(value="创建人昵称")
	@Column(name="create_name")
	private String createName;


	/**
	 *分销积分
	 **/
	@ApiModelProperty(value="分销积分")
	@Column(name="point")
	private Integer point;


	/**
	*分类名
	**/
	@ApiModelProperty(value="分类名")
	@Column(name="category_name")
	private String categoryName;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*分类图片链接
	**/
	@ApiModelProperty(value="分类图片链接")
	@Column(name="picture_url")
	private String pictureUrl;
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
	*排序优先级（展示顺序）
	**/
	@ApiModelProperty(value="排序优先级（展示顺序）")
	@Column(name="priority")
	private Integer priority;
	/**
	*分类描述
	**/
	@ApiModelProperty(value="分类描述")
	@Column(name="description")
	private String description;
	/**
	*父类id
	**/
	@ApiModelProperty(value="父类id")
	@Column(name="parent_category_id")
	private String parentCategoryId;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*是否返积分 0不返 1返积分
	**/
	@ApiModelProperty(value="是否返积分 0不返 1返积分")
	@Column(name="is_rebated")
	private Integer isRebated;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
