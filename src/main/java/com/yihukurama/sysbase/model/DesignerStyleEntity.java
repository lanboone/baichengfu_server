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
 * 说明： 设计师风格表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="设计师风格表")
@Table(name="tb_designer_style")
@Data
public class DesignerStyleEntity extends BaseEntity
{
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*风格示例图
	**/
	@ApiModelProperty(value="风格示例图")
	@Column(name="eg_picture")
	private String egPicture;
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
	*设计师id
	**/
	@ApiModelProperty(value="设计师id")
	@Column(name="designer_id")
	private String designerId;
	/**
	*设计师风格(欧式、日式)
	**/
	@ApiModelProperty(value="设计师风格(欧式、日式)")
	@Column(name="style")
	private String style;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;

	/**
	 *风格描述
	 **/
	@ApiModelProperty(value="风格描述")
	@Column(name="description")
	private String styleDescription;

	/**
	 *序号
	 **/
	@ApiModelProperty(value="序号")
	@Column(name="number")
	private String number;
	
}
