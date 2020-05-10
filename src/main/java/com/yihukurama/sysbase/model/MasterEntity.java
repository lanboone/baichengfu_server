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
 * 说明： 装修师傅表
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value="装修师傅表")
@Table(name="tb_master")
@Data
public class MasterEntity extends BaseEntity
{
	/**
	*个人图片
	**/
	@ApiModelProperty(value="个人图片")
	@Column(name="personal_picture")
	private String personalPicture;
	/**
	*列表的心统计
	**/
	@ApiModelProperty(value="列表的心统计")
	@Column(name="likecount")
	private String likecount;
	/**
	*装修师傅地址
	**/
	@ApiModelProperty(value="装修师傅地址")
	@Column(name="address")
	private String address;
	/**
	*服务价位
	**/
	@ApiModelProperty(value="服务价位")
	@Column(name="service_price")
	private String servicePrice;
	/**
	*最后修改日期
	**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")@Column(name="operate_date")
	private Date operateDate;
	/**
	*排序权重，装修数
	**/
	@ApiModelProperty(value="排序权重，装修数")
	@Column(name="order_count")
	private Integer orderCount;
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
	*荣耀值，装修案例数
	**/
	@ApiModelProperty(value="荣耀值，装修案例数")
	@Column(name="glory_value")
	private Integer gloryValue;
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
	*师傅用户昵称
	**/
	@ApiModelProperty(value="师傅用户昵称")
	@Column(name="nick_name")
	private String nickName;
	/**
	*装修技能，使用分号隔开前面无分号，最后有分号;
	**/
	@ApiModelProperty(value="装修技能，使用分号隔开前面无分号，最后有分号;")
	@Column(name="style")
	private String style;
	/**
	*预留字段5
	**/
	@ApiModelProperty(value="预留字段5")
	@Column(name="parameter5")
	private Integer parameter5;
	/**
	*师傅状态 10 待审核   20已审核
	**/
	@ApiModelProperty(value="师傅状态 10 待审核   20已审核")
	@Column(name="status")
	private Integer status;
	/**
	*最后修改人id
	**/
	@ApiModelProperty(value="最后修改人id")
	@Column(name="operator_id")
	private String operatorId;
	/**
	*师傅用户头像
	**/
	@ApiModelProperty(value="师傅用户头像")
	@Column(name="head_url")
	private String headUrl;
	/**
	*类型  10 个人  20公司
	**/
	@ApiModelProperty(value="类型  10 个人  20公司")
	@Column(name="type")
	private Integer type;
	/**
	*删除状态 0正常 1删除
	**/
	@ApiModelProperty(value="删除状态 0正常 1删除")
	@Column(name="is_delete")
	private Integer isDelete;
	/**
	*证书路径
	**/
	@ApiModelProperty(value="证书路径")
	@Column(name="certificate_url")
	private String certificateUrl;
	/**
	*列表想让他设计统计
	**/
	@ApiModelProperty(value="列表想让他设计统计")
	@Column(name="wantcount")
	private String wantcount;
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
	
	

	
	
}
