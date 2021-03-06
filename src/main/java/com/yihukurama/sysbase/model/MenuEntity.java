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
 * 说明： 保存系统菜单数据;
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="保存系统菜单数据;")
@Table(name="ts_menu")
@Data
public class MenuEntity extends BaseEntity
{
	/**
	*排序字段
	**/
	@ApiModelProperty(value="排序字段")
	@Column(name="index_order")
	private String indexOrder;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*父级菜单id,该值为root代表菜单为一级菜单
	**/
	@ApiModelProperty(value="父级菜单id,该值为root代表菜单为一级菜单")
	@Column(name="parent_id")
	private String parentId;
	/**
	*创建人id
	**/
	@ApiModelProperty(value="创建人id")
	@Column(name="creater_id")
	private String createrId;
	/**
	*菜单编码
	**/
	@ApiModelProperty(value="菜单编码")
	@Column(name="code")
	private String code;
	/**
	*备注信息
	**/
	@ApiModelProperty(value="备注信息")
	@Column(name="note")
	private String note;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*分层路径
	**/
	@ApiModelProperty(value="分层路径")
	@Column(name="path")
	private String path;
	/**
	*is_delete
	**/
	@ApiModelProperty(value="is_delete")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*图标样式
	**/
	@ApiModelProperty(value="图标样式")
	@Column(name="icon_class")
	private String iconClass;
	/**
	*菜单名称
	**/
	@ApiModelProperty(value="菜单名称")
	@Column(name="text")
	private String text;
	/**
	*extjs链接
	**/
	@ApiModelProperty(value="extjs链接")
	@Column(name="link_url")
	private String linkUrl;
	/**
	*菜单接口地址
	**/
	@ApiModelProperty(value="菜单接口地址")
	@Column(name="server_url")
	private String serverUrl;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
