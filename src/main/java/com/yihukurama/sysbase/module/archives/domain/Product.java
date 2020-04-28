package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductEntity;

/**
 * @author: liyuan
 * @date: 2020/4/28 9:54
 * @description: 商品
 */
public class Product extends ProductEntity {
    /**
     * 商品规格
     */
    Productstandard productstandard;

    /**
     * 规格配置列表
     */
    Standardconfig standardconfig;
}
