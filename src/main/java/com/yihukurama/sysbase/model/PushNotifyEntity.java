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
@Table(name="tb_push_notify")
@Data
public class PushNotifyEntity extends BaseEntity
{
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*10广播  20组播
	**/
	@ApiModelProperty(value="10广播  20组播")
	@Column(name="sender_type")
	private Integer senderType;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*显示时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="show_date")
	private Date showDate;
	/**
	*链接
	**/
	@ApiModelProperty(value="链接")
	@Column(name="link")
	private String link;
	/**
	*接收者tag
	**/
	@ApiModelProperty(value="接收者tag")
	@Column(name="receiver_tag")
	private String receiverTag;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*图片
	**/
	@ApiModelProperty(value="图片")
	@Column(name="picture")
	private String picture;
	/**
	*推送内容
	**/
	@ApiModelProperty(value="推送内容")
	@Column(name="content")
	private String content;
	/**
	*10广告消息  20活动消息
	**/
	@ApiModelProperty(value="10广告消息  20活动消息")
	@Column(name="type")
	private Integer type;
	
	

	
	
}
