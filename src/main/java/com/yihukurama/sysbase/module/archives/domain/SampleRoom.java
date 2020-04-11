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
     * 搜索条件   10默认   20最热
     */
    @ApiModelProperty(value = "搜索条件10默认   20最热")
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
}
