package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserProductEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import lombok.Data;

@Data
public class AppuserProduct extends AppuserProductEntity {

    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;

    /**
     * 关联的商品
     */
    ProductEntity productEntity;

}
