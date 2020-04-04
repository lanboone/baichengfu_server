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
 * 说明： 样板间表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="样板间表")
@Table(name="tb_sample_room")
@Data
public class SampleRoomEntity extends BaseEntity
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
	
	

	
	
}
