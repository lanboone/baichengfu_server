package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductCategoriesEntity;
import lombok.Data;

/**
 * @author: liyuan
 * @date: 2020/4/25 16:09
 * @description: 商品分类对象
 */
@Data
public class Productcategories extends ProductCategoriesEntity {
    /**
     * 创建人姓名
     */
    String creator;

}
