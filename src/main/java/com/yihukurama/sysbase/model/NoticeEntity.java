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
 * 说明： 系统通知表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="系统通知表")
@Table(name="tb_notice")
public class NoticeEntity extends BaseEntity
{
	/**
	*通知标题
	**/
	@ApiModelProperty(value="通知标题")
	@Column(name="notice_title")
	private String noticeTitle;
	/**
	*更新时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="modify_time")
	private Date modifyTime;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*通知内容
	**/
	@ApiModelProperty(value="通知内容")
	@Column(name="notice_content")
	private String noticeContent;
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
	*通知链接
	**/
	@ApiModelProperty(value="通知链接")
	@Column(name="notice_link")
	private String noticeLink;
	/**
	*通知分类
	**/
	@ApiModelProperty(value="通知分类")
	@Column(name="notice_type")
	private String noticeType;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*预留字段1
	**/
	@ApiModelProperty(value="预留字段1")
	@Column(name="parameter1")
	private String parameter1;
	/**
	*管理员id
	**/
	@ApiModelProperty(value="管理员id")
	@Column(name="manager_id")
	private String managerId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_time")
	private Date createTime;
	/**
	*预留字段5
	**/
	@ApiModelProperty(value="预留字段5")
	@Column(name="parameter5")
	private Integer parameter5;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*预留字段4
	**/
	@ApiModelProperty(value="预留字段4")
	@Column(name="parameter4")
	private String parameter4;
	/**
	*通知时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="notice_time")
	private Date noticeTime;
	/**
	*预留字段3
	**/
	@ApiModelProperty(value="预留字段3")
	@Column(name="parameter3")
	private String parameter3;
	/**
	*预留字段2
	**/
	@ApiModelProperty(value="预留字段2")
	@Column(name="parameter2")
	private String parameter2;
	
	

	public String getNoticeTitle(){
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle){
		this.noticeTitle = noticeTitle;
	}

	public Date getModifyTime(){
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public String getNoticeContent(){
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent){
		this.noticeContent = noticeContent;
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

	public String getNoticeLink(){
		return noticeLink;
	}

	public void setNoticeLink(String noticeLink){
		this.noticeLink = noticeLink;
	}

	public String getNoticeType(){
		return noticeType;
	}

	public void setNoticeType(String noticeType){
		this.noticeType = noticeType;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public String getParameter1(){
		return parameter1;
	}

	public void setParameter1(String parameter1){
		this.parameter1 = parameter1;
	}

	public String getManagerId(){
		return managerId;
	}

	public void setManagerId(String managerId){
		this.managerId = managerId;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Integer getParameter5(){
		return parameter5;
	}

	public void setParameter5(Integer parameter5){
		this.parameter5 = parameter5;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public String getParameter4(){
		return parameter4;
	}

	public void setParameter4(String parameter4){
		this.parameter4 = parameter4;
	}

	public Date getNoticeTime(){
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime){
		this.noticeTime = noticeTime;
	}

	public String getParameter3(){
		return parameter3;
	}

	public void setParameter3(String parameter3){
		this.parameter3 = parameter3;
	}

	public String getParameter2(){
		return parameter2;
	}

	public void setParameter2(String parameter2){
		this.parameter2 = parameter2;
	}

	
	

	
	
}
