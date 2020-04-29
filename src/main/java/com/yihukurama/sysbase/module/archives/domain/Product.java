package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.ProductstandardEntity;
import com.yihukurama.sysbase.model.StandardconfigEntity;
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
    List<ProductstandardEntity> productStandardEntityList;

    /**
     * 规格配置列表
     */
    List<StandardconfigEntity> standardConfigEntityList;
}
