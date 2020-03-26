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
 * 说明： 保存全系统短信发送记录;
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="保存全系统短信发送记录;")
@Table(name="ts_smsrecord")
public class SmsrecordEntity extends BaseEntity
{
	/**
	*接收人姓名
	**/
	@ApiModelProperty(value="接收人姓名")
	@Column(name="receiver")
	private String receiver;
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
	*接收人手机号码
	**/
	@ApiModelProperty(value="接收人手机号码")
	@Column(name="mobile")
	private String mobile;
	/**
	*短信关联事故id
	**/
	@ApiModelProperty(value="短信关联事故id")
	@Column(name="record_id")
	private String recordId;
	/**
	*状态,1未发送,2发送成功,3发送失败
	**/
	@ApiModelProperty(value="状态,1未发送,2发送成功,3发送失败")
	@Column(name="status")
	private Integer status;
	/**
	*错误代码
	**/
	@ApiModelProperty(value="错误代码")
	@Column(name="error_code")
	private String errorCode;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*失败原因
	**/
	@ApiModelProperty(value="失败原因")
	@Column(name="reason")
	private String reason;
	/**
	*短信内容
	**/
	@ApiModelProperty(value="短信内容")
	@Column(name="content")
	private String content;
	/**
	*类型
	**/
	@ApiModelProperty(value="类型")
	@Column(name="type")
	private Integer type;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*发送时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="send_date")
	private Date sendDate;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	public String getReceiver(){
		return receiver;
	}

	public void setReceiver(String receiver){
		this.receiver = receiver;
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

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getRecordId(){
		return recordId;
	}

	public void setRecordId(String recordId){
		this.recordId = recordId;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public String getErrorCode(){
		return errorCode;
	}

	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}

	public String getOperatorId(){
		return operatorId;
	}

	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}

	public String getReason(){
		return reason;
	}

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getIsDelete(){
		return isDelete;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public Date getSendDate(){
		return sendDate;
	}

	public void setSendDate(Date sendDate){
		this.sendDate = sendDate;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	
	

	
	
}
