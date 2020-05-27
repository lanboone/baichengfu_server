package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserProductEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import lombok.Data;

@Data
public class AppuserProduct extends AppuserProductEntity {

    /**
     * 关联的商品
     */
    ProductEntity productEntity;

}
