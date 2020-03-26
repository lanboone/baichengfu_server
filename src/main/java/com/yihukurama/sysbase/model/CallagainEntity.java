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
 * 说明： 回调表 tb_callagain(回调表)
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="回调表 tb_callagain(回调表)")
@Table(name="tb_callagain")
public class CallagainEntity extends BaseEntity
{
	/**
	*间隔（分钟）(例子[1, 2, 3])
	**/
	@ApiModelProperty(value="间隔（分钟）(例子[1, 2, 3])")
	@Column(name="intervals")
	private String intervals;
	/**
	* 上次回调时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="last_time")
	private Date lastTime;
	/**
	*关联id
	**/
	@ApiModelProperty(value="关联id")
	@Column(name="relate_id")
	private String relateId;
	/**
	*回调次数
	**/
	@ApiModelProperty(value="回调次数")
	@Column(name="count")
	private Integer count;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	* 回调参数
	**/
	@ApiModelProperty(value=" 回调参数")
	@Column(name="params")
	private String params;
	/**
	* 回调类型
	**/
	@ApiModelProperty(value=" 回调类型")
	@Column(name="type")
	private String type;
	
	

	public String getIntervals(){
		return intervals;
	}

	public void setIntervals(String intervals){
		this.intervals = intervals;
	}

	public Date getLastTime(){
		return lastTime;
	}

	public void setLastTime(Date lastTime){
		this.lastTime = lastTime;
	}

	public String getRelateId(){
		return relateId;
	}

	public void setRelateId(String relateId){
		this.relateId = relateId;
	}

	public Integer getCount(){
		return count;
	}

	public void setCount(Integer count){
		this.count = count;
	}

	public String getCreaterId(){
		return createrId;
	}

	public void setCreaterId(String createrId){
		this.createrId = createrId;
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

	public String getParams(){
		return params;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	
	

	
	
}
