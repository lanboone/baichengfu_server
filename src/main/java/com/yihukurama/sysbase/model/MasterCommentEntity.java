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
@ApiModel(value="安装师傅评论表")
@Table(name="tb_master_comment")
@Data
public class MasterCommentEntity extends BaseEntity
{
	/**
	 *订单号
	 **/
	@ApiModelProperty(value="关联订单号")
	@Column(name="order_num")
	private String orderNum;


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
	*星级评价
	**/
	@ApiModelProperty(value="星级评价")
	@Column(name="star")
	private Integer star;
	/**
	*评论时的商品详情
	**/
	@ApiModelProperty(value="评论时的商品详情")
	@Column(name="product_detail")
	private String productDetail;
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
	*商品名称
	**/
	@ApiModelProperty(value="商品名称")
	@Column(name="product_name")
	private String productName;
	/**
	*商品id
	**/
	@ApiModelProperty(value="商品id")
	@Column(name="master_id")
	private String masterId;
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
	*关联的订单id
	**/
	@ApiModelProperty(value="关联的订单id")
	@Column(name="order_id")
	private String orderId;
	/**
	*该评论回复的id集合，时间越早的在约前面
	**/
	@ApiModelProperty(value="该评论回复的id集合，时间越早的在约前面")
	@Column(name="reply_path")
	private String replyPath;
	/**
	*评论内容
	**/
	@ApiModelProperty(value="评论内容")
	@Column(name="comment_content")
	private String commentContent;
	/**
	*评论的图片，视频访问路径，用分号隔开，用后缀区分
	**/
	@ApiModelProperty(value="评论的图片，视频访问路径，用分号隔开，用后缀区分")
	@Column(name="pics")
	private String pics;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*reply
	**/
	@ApiModelProperty(value="reply")
	@Column(name="reply")
	private String reply;
	
	

	
	
}
