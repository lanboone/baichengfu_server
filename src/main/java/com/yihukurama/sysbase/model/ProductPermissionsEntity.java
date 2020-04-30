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
 * 说明： 操作权限表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="操作权限表")
@Table(name="tb_product_permissions")
@Data
public class ProductPermissionsEntity extends BaseEntity
{
	/**
	*查
	**/
	@ApiModelProperty(value="查")
	@Column(name="query_")
	private String query;
	/**
	*改
	**/
	@ApiModelProperty(value="改")
	@Column(name="change_")
	private String change;
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
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*拥有操作权限的商品分类id
	**/
	@ApiModelProperty(value="拥有操作权限的商品分类id")
	@Column(name="category_id")
	private String categoryId;
	/**
	*管理员id
	**/
	@ApiModelProperty(value="管理员id")
	@Column(name="manager_id")
	private String managerId;
	/**
	*删
	**/
	@ApiModelProperty(value="删")
	@Column(name="delete_")
	private String delete;
	/**
	*增
	**/
	@ApiModelProperty(value="增")
	@Column(name="increase_")
	private String increase;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*销售员id
	**/
	@ApiModelProperty(value="销售员id")
	@Column(name="seller_id")
	private String sellerId;
	
	

	
	
}
