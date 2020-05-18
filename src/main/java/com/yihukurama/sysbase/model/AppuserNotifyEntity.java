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
 * 说明： 用户消息表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="用户消息表")
@Table(name="tb_appuser_notify")
@Data
public class AppuserNotifyEntity extends BaseEntity
{
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*接收者头像
	**/
	@ApiModelProperty(value="接收者头像")
	@Column(name="receiver_head")
	private String receiverHead;
	/**
	*10APP用户  20后台客服
	**/
	@ApiModelProperty(value="10APP用户  20后台客服")
	@Column(name="sender_type")
	private Integer senderType;
	/**
	*发送者头像
	**/
	@ApiModelProperty(value="发送者头像")
	@Column(name="sender_head")
	private String senderHead;
	/**
	*接收者id
	**/
	@ApiModelProperty(value="接收者id")
	@Column(name="receiver_id")
	private String receiverId;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*订单id
	**/
	@ApiModelProperty(value="订单id")
	@Column(name="order_id")
	private String orderId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*发送者id
	**/
	@ApiModelProperty(value="发送者id")
	@Column(name="sender_id")
	private String senderId;
	/**
	*聊天内容
	**/
	@ApiModelProperty(value="聊天内容")
	@Column(name="content")
	private String content;
	
	

	
	
}
