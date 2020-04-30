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
 * 说明： 用户地址表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="用户地址表")
@Table(name="tb_user_address")
@Data
public class UserAddressEntity extends BaseEntity
{
	/**
	*详细地址
	**/
	@ApiModelProperty(value="详细地址")
	@Column(name="detailed_address")
	private String detailedAddress;
	/**
	*国家
	**/
	@ApiModelProperty(value="国家")
	@Column(name="country")
	private String country;
	/**
	*邮政编码
	**/
	@ApiModelProperty(value="邮政编码")
	@Column(name="code")
	private String code;
	/**
	*城市
	**/
	@ApiModelProperty(value="城市")
	@Column(name="city")
	private String city;
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
	*省份
	**/
	@ApiModelProperty(value="省份")
	@Column(name="province")
	private String province;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*街道
	**/
	@ApiModelProperty(value="街道")
	@Column(name="street")
	private String street;
	/**
	*区
	**/
	@ApiModelProperty(value="区")
	@Column(name="region")
	private String region;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
