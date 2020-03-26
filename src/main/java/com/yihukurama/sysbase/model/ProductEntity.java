package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class ProductEntity extends BaseEntity
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
	
	

	public String getQuery(){
		return query;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getChange(){
		return change;
	}

	public void setChange(String change){
		this.change = change;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public Date getOperateDate(){
		return operateDate;
	}

	public void setOperateDate(Date operateDate){
		this.operateDate = operateDate;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getManagerId(){
		return managerId;
	}

	public void setManagerId(String managerId){
		this.managerId = managerId;
	}

	public String getDelete(){
		return delete;
	}

	public void setDelete(String delete){
		this.delete = delete;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getIncrease(){
		return increase;
	}

	public void setIncrease(String increase){
		this.increase = increase;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public String getSellerId(){
		return sellerId;
	}

	public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}

	
	

	
	
}
