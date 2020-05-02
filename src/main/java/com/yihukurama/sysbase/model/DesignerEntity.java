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
 * 说明： 设计师表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="设计师表")
@Table(name="tb_designer")
@Data
public class DesignerEntity extends BaseEntity
{

	/**
	 *设计师头像
	 **/
	@ApiModelProperty(value="设计师头像")
	@Column(name="head_url")
	private String headUrl;
	/**
	 *设计师昵称
	 **/
	@ApiModelProperty(value="设计师昵称")
	@Column(name="nick_name")
	private String nickName;
	/**
	 *设计师列表的心统计
	 **/
	@ApiModelProperty(value="设计师列表的心统计")
	@Column(name="likecount")
	private Long likecount;

	/**
	 *设计师状态 10 待审核   20已审核
	 **/
	@ApiModelProperty(value="设计师状态 10 待审核   20已审核")
	@Column(name="status")
	private Long status;

	/**
	 *设计师里列表想让他设计统计
	 **/
	@ApiModelProperty(value="设计师里列表想让他设计统计")
	@Column(name="wantcount")
	private Long wantcount;

	/**
	*个人图片
	**/
	@ApiModelProperty(value="个人图片")
	@Column(name="personal_picture")
	private String personalPicture;
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
	*作品id列表
	**/
	@ApiModelProperty(value="作品id列表")
	@Column(name="works_ids")
	private String worksIds;
	/**
	*荣耀值
	**/
	@ApiModelProperty(value="荣耀值")
	@Column(name="glory_value")
	private Integer gloryValue;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*设计师地址
	**/
	@ApiModelProperty(value="设计师地址")
	@Column(name="address")
	private String address;
	/**
	*用户id
	**/
	@ApiModelProperty(value="用户id")
	@Column(name="user_id")
	private String userId;
	/**
	*简介
	**/
	@ApiModelProperty(value="简介")
	@Column(name="remark")
	private String remark;
	/**
	*每平米平均价格
	**/
	@ApiModelProperty(value="每平米平均价格")
	@Column(name="price_per")
	private Integer pricePer;
	/**
	*设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;
	**/
	@ApiModelProperty(value="设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;")
	@Column(name="style")
	private String style;
	/**
	*预留字段5
	**/
	@ApiModelProperty(value="预留字段5")
	@Column(name="parameter5")
	private Integer parameter5;
	/**
	*个人介绍
	**/
	@ApiModelProperty(value="个人介绍")
	@Column(name="introduction")
	private String introduction;
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
	
	

	
	
}
