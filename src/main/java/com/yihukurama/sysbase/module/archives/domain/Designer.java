package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Designer extends DesignerEntity {


    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "nick_name")
    @Override
    public String getNickName() {
        return super.getNickName();
    }

    /**
     * 传入的多个风格，用;隔开
     */
    private String searchStyles;

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


    @ApiModelProperty(value = "设计师在app上的用户名")
    private String appUserName;
    @ApiModelProperty(value = "设计师在app上的手机号")
    private String appUserPhone;

    /**
     * 需求搜索设计师需要对设计师名或风格模糊搜索
     */
    @ApiModelProperty(value = "对设计师名或风格模糊搜索")
    private String keyWords;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LOCATE,proprtityName = "address")
    @Override
    public String getAddress() {
        return super.getAddress();
    }

}
