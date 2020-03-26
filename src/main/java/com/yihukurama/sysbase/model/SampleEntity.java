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
 * 说明： 样板间表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="样板间表")
@Table(name="tb_sample_room")
public class SampleEntity extends BaseEntity
{
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
	*上传者类型（管理员或用户）
	**/
	@ApiModelProperty(value="上传者类型（管理员或用户）")
	@Column(name="uploader_type")
	private String uploaderType;
	/**
	*样板间分类
	**/
	@ApiModelProperty(value="样板间分类")
	@Column(name="sample_type")
	private String sampleType;
	/**
	*样板间标题
	**/
	@ApiModelProperty(value="样板间标题")
	@Column(name="sample_title")
	private String sampleTitle;
	/**
	*样板间链接
	**/
	@ApiModelProperty(value="样板间链接")
	@Column(name="sample_link")
	private String sampleLink;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*样板间图片
	**/
	@ApiModelProperty(value="样板间图片")
	@Column(name="sample_image")
	private String sampleImage;
	/**
	*管理员id
	**/
	@ApiModelProperty(value="管理员id")
	@Column(name="manager_id")
	private String managerId;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="user_id")
	private String userId;
	/**
	*样板间收藏数
	**/
	@ApiModelProperty(value="样板间收藏数")
	@Column(name="s_favorite_number")
	private Integer sFavoriteNumber;
	/**
	*样板间面积（平方）
	**/
	@ApiModelProperty(value="样板间面积（平方）")
	@Column(name="sample_area")
	private String sampleArea;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

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

	public String getUploaderType(){
		return uploaderType;
	}

	public void setUploaderType(String uploaderType){
		this.uploaderType = uploaderType;
	}

	public String getSampleType(){
		return sampleType;
	}

	public void setSampleType(String sampleType){
		this.sampleType = sampleType;
	}

	public String getSampleTitle(){
		return sampleTitle;
	}

	public void setSampleTitle(String sampleTitle){
		this.sampleTitle = sampleTitle;
	}

	public String getSampleLink(){
		return sampleLink;
	}

	public void setSampleLink(String sampleLink){
		this.sampleLink = sampleLink;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public String getSampleImage(){
		return sampleImage;
	}

	public void setSampleImage(String sampleImage){
		this.sampleImage = sampleImage;
	}

	public String getManagerId(){
		return managerId;
	}

	public void setManagerId(String managerId){
		this.managerId = managerId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public Integer getSFavoriteNumber(){
		return sFavoriteNumber;
	}

	public void setSFavoriteNumber(Integer sFavoriteNumber){
		this.sFavoriteNumber = sFavoriteNumber;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getSampleArea(){
		return sampleArea;
	}

	public void setSampleArea(String sampleArea){
		this.sampleArea = sampleArea;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
