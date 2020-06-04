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
 * 说明： 广告图表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="广告图表")
@Table(name="tb_banner")
@Data
public class BannerEntity extends BaseEntity
{


	/**
	 *类型
	 **/
	@ApiModelProperty(value="类型")
	@Column(name="type")
	private Integer type;

	/**
	*广告图
	**/
	@ApiModelProperty(value="广告图")
	@Column(name="ads_pictures")
	private String adsPictures;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
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
	*链接url
	**/
	@ApiModelProperty(value="链接url")
	@Column(name="link_url")
	private String linkUrl;
	/**
	*创建时间
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="create_date")
	private Date createDate;
	/**
	*图片url
	**/
	@ApiModelProperty(value="图片url")
	@Column(name="pic_url")
	private String picUrl;
	/**
	 *banner描述
	 **/
	@ApiModelProperty(value="banner描述")
	@Column(name="description")
	private String description;
	/**
	 * 是否投放 0否 1是
	 **/
	@ApiModelProperty(value="是否投放 0否 1是")
	@Column(name="is_drop")
	private Boolean isDrop;




}
