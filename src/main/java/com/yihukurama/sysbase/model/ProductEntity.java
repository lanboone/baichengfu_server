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
 * 说明： 商品表
 *
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value = "商品表")
@Table(name = "tb_product")
@Data
public class ProductEntity extends BaseEntity {

    /**
     * 商品名
     **/
    @ApiModelProperty(value = "商品名")
    @Column(name = "product_name")
    private String productName;
    /**
     * 简介
     **/
    @ApiModelProperty(value = "简介")
    @Column(name = "profile")
    private String profile;
    /**
     * 子分类id
     **/
    @ApiModelProperty(value = "子分类id")
    @Column(name = "categories_id")
    private String categoriesId;

    /**
     * 封面图片链接列表,用;分号分割
     **/
    @ApiModelProperty(value = "封面图片链接列表,用;分号分割")
    @Column(name = "cover_images")
    private String coverImages;
    /**
     * 封面视频链接
     **/
    @ApiModelProperty(value = "封面视频链接")
    @Column(name = "cover_video")
    private String coverVideo;
    /**
     * 预付比例
     **/
    @ApiModelProperty(value = "预付比例")
    @Column(name = "prepaid_ratio")
    private String prepaidRatio;

    /**
     * 收藏数
     **/
    @ApiModelProperty(value = "收藏数")
    @Column(name = "favorite_number")
    private Integer favoriteNumber;
    /**
     * 是否推荐到首页 0否 1是
     **/
    @ApiModelProperty(value = "是否推荐到首页 0否 1是")
    @Column(name = "is_recommend")
    private boolean recommend;
    /**
     * 推荐位排序号
     **/
    @ApiModelProperty(value = "推荐位排序号")
    @Column(name = "recommend_sort")
    private Integer recommendSort;
    /**
     * 销量
     **/
    @ApiModelProperty(value = "销量")
    @Column(name = "sales_volume")
    private Integer salesVolume;
    /**
     * 最后修改日期
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "operate_date")
    private Date operateDate;


    /**
     * 创建人id
     **/
    @ApiModelProperty(value = "创建人id")
    @Column(name = "creater_id")
    private String createrId;
    /**
     * 删除状态 0正常 1删除
     **/
    @ApiModelProperty(value = "删除状态 0正常 1删除")
    @Column(name = "is_delete")
    private Integer isDelete;
    /**
     * 最后修改人id
     **/
    @ApiModelProperty(value = "最后修改人id")
    @Column(name = "operator_id")
    private String operatorId;

    /**
     * 创建时间
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;

    public boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
