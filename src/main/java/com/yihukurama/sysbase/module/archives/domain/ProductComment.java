package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductCommentEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import lombok.Data;

@Data
public class ProductComment extends ProductCommentEntity {


    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "product_name")
    @Override
    public String getProductName() {
        return super.getProductName();
    }

}
