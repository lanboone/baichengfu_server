package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductCategoriesEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.ProductStandardEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: liyuan
 * @date: 2020/4/28 9:54
 * @description: 商品
 */
@Data
public class Product extends ProductEntity {

    /**
     * 商品筛选分类id
     */
    @ApiModelProperty(value = "按分类搜索多选")
    private String searchCategoriesIds;
    /**
     * 搜索框传入的值
     */
    @ApiModelProperty(value = "搜索框传入的值")
    private String keyWords;

    /**
     * 商品规格列表
     */
    List<ProductStandardEntity> productStandardEntityList;

    /**
     * 规格配置列表
     */
    List<StandardConfigEntity> standardConfigEntityList;

    /**
     * 搜索条件   10综合排序   20销量排序  30热门   40价格升序  50价格降序
     */
    @ApiModelProperty(value = "10综合排序   20销量排序  30热门   40价格升序  50价格降序")
    private Integer searchType;
    public static final int SEARCH_TYPE_10 = 10;
    public static final int SEARCH_TYPE_20 = 20;
    public static final int SEARCH_TYPE_30 = 30;
    public static final int SEARCH_TYPE_40 = 40;
    public static final int SEARCH_TYPE_50 = 50;



    /**
     * 样板间关联的商品
     */
    private List<ProductEntity> productEntityList;

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
    @SqlWhere(value = SqlWhere.SqlWhereValue.GT,proprtityName = "ref_price")
    public Double getGtCost() {
        return gtCost;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LT,proprtityName = "ref_price")
    public Double getLtCost() {
        return ltCost;
    }

    ProductCategoriesEntity productCategoriesEntity;
}
