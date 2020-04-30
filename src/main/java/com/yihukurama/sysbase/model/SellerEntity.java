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
 * 说明： 售前售后表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="售前售后表")
@Table(name="tb_seller")
@Data
public class SellerEntity extends BaseEntity
{
	/**
	*销售员密码
	**/
	@ApiModelProperty(value="销售员密码")
	@Column(name="seller_passwaord")
	private String sellerPasswaord;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*销售员名称
	**/
	@ApiModelProperty(value="销售员名称")
	@Column(name="seller_name")
	private String sellerName;
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
	*所属管理员id
	**/
	@ApiModelProperty(value="所属管理员id")
	@Column(name="belong_manager")
	private String belongManager;
	/**
	*关联权限id列表
	**/
	@ApiModelProperty(value="关联权限id列表")
	@Column(name="permission_list")
	private String permissionList;
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
	*类型（总售前、总售后、售前、售后）
	**/
	@ApiModelProperty(value="类型（总售前、总售后、售前、售后）")
	@Column(name="type")
	private String type;
	
	

	
	
}
