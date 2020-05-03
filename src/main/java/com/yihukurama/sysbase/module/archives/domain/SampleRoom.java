package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 说明： 样板间实体类
 * @author yihukurama
 * @date Created in 11:04 2020/4/11
 *       Modified by yihukurama in 11:04 2020/4/11
 */
@Data
public class SampleRoom extends SampleRoomEntity {


    /**
     * 搜索条件   10默认时间   20最热权重
     */
    @ApiModelProperty(value = "搜索条件10默认时间   20最热权重")
    private Integer searchType;
    /**
     * 样板间关联的商品
     */
    private List<ProductEntity> productEntityList;

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "sample_title")
    @Override
    public String getSampleTitle() {
        return super.getSampleTitle();
    }

    private Double GTECost;
    private Double LTECost;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GTE,proprtityName = "cost")
    public Double getGTECost() {
        return GTECost;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LTE,proprtityName = "cost")
    public Double getLTECost() {
        return LTECost;
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LOCATE,proprtityName = "sample_type")
    @Override
    public String getSampleType() {
        return super.getSampleType();
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LOCATE,proprtityName = "furniture")
    @Override
    public String getFurniture() {
        return super.getFurniture();
    }

    @SqlWhere(value = SqlWhere.SqlWhereValue.LOCATE,proprtityName = "material")
    @Override
    public String getMaterial() {
        return super.getMaterial();
    }
}
