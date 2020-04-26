package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ProductCategoriesEntity;
import com.yihukurama.sysbase.model.TopicEntity;
import com.yihukurama.sysbase.module.archives.domain.Productcategories;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.stereotype.Service;

@Service
public class ProductcategoriesService extends CrudService<ProductCategoriesEntity> {

    @Override
    public Result list(ProductCategoriesEntity productCategoriesEntity, Integer page, Integer limit) throws TipsException {
        productCategoriesEntity.setSortSql("priority");
        Result result = super.list(productCategoriesEntity, page, limit);
        return result;
    }
}
