package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.ProductStandardEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
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
     * 商品规格列表
     */
    List<ProductStandardEntity> productStandardEntityList;

    /**
     * 规格配置列表
     */
    List<StandardConfigEntity> standardConfigEntityList;
}
