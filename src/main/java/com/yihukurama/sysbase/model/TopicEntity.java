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
 * 说明： 话题表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="话题表")
@Table(name="tb_topic")
@Data
public class TopicEntity extends BaseEntity
{
	/**
	*创建者类型（管理员或用户）
	**/
	@ApiModelProperty(value="创建者类型（管理员或用户）")
	@Column(name="creator_type")
	private String creatorType;
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
	*话题浏览数
	**/
	@ApiModelProperty(value="话题浏览数")
	@Column(name="t_viewing_count")
	private Integer tViewingCount;
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
	*话题收藏数
	**/
	@ApiModelProperty(value="话题收藏数")
	@Column(name="t_favorite_number")
	private Integer tFavoriteNumber;
	/**
	*话题内容
	**/
	@ApiModelProperty(value="话题内容")
	@Column(name="topic_content")
	private String topicContent;
	/**
	*话题标题
	**/
	@ApiModelProperty(value="话题标题")
	@Column(name="topic_title")
	private String topicTitle;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
