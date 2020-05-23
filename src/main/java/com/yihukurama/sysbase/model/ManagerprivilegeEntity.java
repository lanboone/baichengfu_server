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
 * 说明： 地区信息表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="地区信息表")
@Table(name="tb_managerprivilege")
@Data
public class ManagerprivilegeEntity extends BaseEntity
{
	/**
	*is_delete
	**/
	@ApiModelProperty(value="is_delete")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*菜单/功能id
	**/
	@ApiModelProperty(value="菜单/功能id")
	@Column(name="privilege_id")
	private String privilegeId;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="manager_id")
	private String managerId;
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
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*权限类型,10菜单,20商品分类
	**/
	@ApiModelProperty(value="权限类型,10菜单,20商品分类")
	@Column(name="type")
	private Integer type;
	
	

	
	
}
