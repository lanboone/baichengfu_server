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
 * 说明： 帮助表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="商品表")
@Table(name="tb_help")
@Data
public class HelpEntity extends BaseEntity
{
	/**
	*标题
	**/
	@ApiModelProperty(value="标题")
	@Column(name="title")
	private String title;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*排序
	**/
	@ApiModelProperty(value="排序")
	@Column(name="index_order")
	private Integer indexOrder;
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
	*封面图片链接列表,用;分号分割
	**/
	@ApiModelProperty(value="封面图片链接列表,用;分号分割")
	@Column(name="images")
	private String images;
	/**
	*内容
	**/
	@ApiModelProperty(value="内容")
	@Column(name="content")
	private String content;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*创建人
	**/
	@ApiModelProperty(value="创建人")
	@Column(name="creater_name")
	private String createrName;
	/**
	*是否上下架 0下架 1上架
	**/
	@ApiModelProperty(value="是否上下架 0下架 1上架")
	@Column(name="status")
	private Integer status;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	
	

	
	
}
