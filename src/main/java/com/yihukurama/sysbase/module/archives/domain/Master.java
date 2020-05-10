package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.MasterEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Master extends MasterEntity {

    /**
     * 传入的多个技能，用;隔开
     */
    private String searchSkills;

    /**
     * 查询时 大于等于该价格
     */
    @ApiModelProperty(value = "查询时 大于等于该价格")
    private Double gtCost;
    /**
     * 查询时 小于等于该价格
     */
    @ApiModelProperty(value = "查询时 小于等于该价格")
    private Double ltCost;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GT,proprtityName = "price_per")
    public Double getGtCost() {
        return gtCost;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LT,proprtityName = "price_per")
    public Double getLtCost() {
        return ltCost;
    }


    /**
     * 搜索条件   10默认综合权重排序   20最热排序
     */
    @ApiModelProperty(value = "搜索条件   10默认综合权重排序   20最热排序")
    private Integer searchType;


    @ApiModelProperty(value = "装修师傅在app上的用户名")
    private String appUserName;
    @ApiModelProperty(value = "装修师傅在app上的手机号")
    private String appUserPhone;

    /**
     * 需求搜索装修师傅需要对装修师傅名或技能模糊搜索
     */
    @ApiModelProperty(value = "对装修师傅名或技能模糊搜索")
    private String keyWords;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LOCATE,proprtityName = "address")
    @Override
    public String getAddress() {
        return super.getAddress();
    }

}
