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
 * 说明： 话题评论表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="话题评论表")
@Table(name="tb_topic_comment")
@Data
public class TopicCommentEntity extends BaseEntity
{
	/**
	*创建者昵称
	**/
	@ApiModelProperty(value="创建者昵称")
	@Column(name="comment_name")
	private String commentName;
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
	*父评论id
	**/
	@ApiModelProperty(value="父评论id")
	@Column(name="c_parent_id")
	private String cParentId;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*创建者头像
	**/
	@ApiModelProperty(value="创建者头像")
	@Column(name="comment_head")
	private String commentHead;
	/**
	*话题id
	**/
	@ApiModelProperty(value="话题id")
	@Column(name="topic_id")
	private String topicId;
	/**
	 *要显示的评论json
	 **/
	@ApiModelProperty(value="要显示的评论json")
	@Column(name="reply")
	private String reply;
	/**
	*该评论回复的id集合，时间越早的在约前面
	**/
	@ApiModelProperty(value="该评论回复的id集合，时间越早的在约前面")
	@Column(name="reply_path")
	private String replyPath;
	/**
	*话题评论内容
	**/
	@ApiModelProperty(value="话题评论内容")
	@Column(name="comment_content")
	private String commentContent;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
