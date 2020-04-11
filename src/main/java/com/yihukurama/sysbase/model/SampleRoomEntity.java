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
	 *排序权重，收藏数+浏览数
	 **/
	@ApiModelProperty(value="排序权重，收藏数+浏览数")
	@Column(name="order_count")
	private Integer orderCount;


	/**
	*费用
	**/
	@ApiModelProperty(value="费用")
	@Column(name="cost")
	private String cost;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*设计师昵称
	**/
	@ApiModelProperty(value="设计师昵称")
	@Column(name="designer_name")
	private String designerName;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*设计师id
	**/
	@ApiModelProperty(value="设计师id")
	@Column(name="designer_id")
	private String designerId;
	/**
	*样板间标题
	**/
	@ApiModelProperty(value="样板间标题")
	@Column(name="sample_title")
	private String sampleTitle;
	/**
	*样板间浏览数
	**/
	@ApiModelProperty(value="样板间浏览数")
	@Column(name="focus_count")
	private Integer focusCount;
	/**
	*样板间链接
	**/
	@ApiModelProperty(value="样板间链接")
	@Column(name="sample_link")
	private String sampleLink;
	/**
	*材质
	**/
	@ApiModelProperty(value="材质")
	@Column(name="material")
	private String material;
	/**
	*简介
	**/
	@ApiModelProperty(value="简介")
	@Column(name="note")
	private String note;
	/**
	*设计师头像
	**/
	@ApiModelProperty(value="设计师头像")
	@Column(name="designer_head")
	private String designerHead;
	/**
	*摘要
	**/
	@ApiModelProperty(value="摘要")
	@Column(name="tips")
	private String tips;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*上传者类型10管理员20用户）
	**/
	@ApiModelProperty(value="上传者类型10管理员20用户）")
	@Column(name="uploader_type")
	private Integer uploaderType;
	/**
	*样板间风格
	**/
	@ApiModelProperty(value="样板间风格")
	@Column(name="sample_type")
	private String sampleType;
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
	*样板间封面图，每个图片链接使用分号分割
	**/
	@ApiModelProperty(value="样板间封面图，每个图片链接使用分号分割")
	@Column(name="sample_image")
	private String sampleImage;
	/**
	*管理员id
	**/
	@ApiModelProperty(value="管理员id")
	@Column(name="manager_id")
	private String managerId;
	/**
	*样板间收藏数
	**/
	@ApiModelProperty(value="样板间收藏数")
	@Column(name="s_favorite_number")
	private Integer sFavoriteNumber;
	/**
	*定制家具
	**/
	@ApiModelProperty(value="定制家具")
	@Column(name="furniture")
	private String furniture;
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
