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
@Table(name="tb_appuser_room")
@Data
public class AppuserRoomEntity extends BaseEntity
{
	/**
	*面积（平方）
	**/
	@ApiModelProperty(value="面积（平方）")
	@Column(name="area")
	private String area;
	/**
	*预算
	**/
	@ApiModelProperty(value="预算")
	@Column(name="cost")
	private String cost;
	/**
	*备注
	**/
	@ApiModelProperty(value="备注")
	@Column(name="note")
	private String note;
	/**
	*所在地
	**/
	@ApiModelProperty(value="所在地")
	@Column(name="address")
	private String address;
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
	*设计效果图
	**/
	@ApiModelProperty(value="设计效果图")
	@Column(name="design_pics")
	private String designPics;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
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
	*详细地址
	**/
	@ApiModelProperty(value="详细地址")
	@Column(name="address_detail")
	private String addressDetail;
	/**
	*图片
	**/
	@ApiModelProperty(value="图片")
	@Column(name="pics")
	private String pics;
	/**
	*系统设计富文本
	**/
	@ApiModelProperty(value="系统设计富文本")
	@Column(name="design_note")
	private String designNote;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
