package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.ManagerMapper;
import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.model.ProductCategoriesEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.archives.domain.ProductCategories;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoriesService extends CrudService<ProductCategoriesEntity> {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Result list(ProductCategoriesEntity productCategoriesEntity, Integer page, Integer limit) throws TipsException {
        productCategoriesEntity.setSortSql("priority");
        Result result = super.list(productCategoriesEntity, page, limit);

        List<ProductCategoriesEntity> productCategoriesEntityList = (List<ProductCategoriesEntity>) result.getData();
        List<ProductCategories> productcategoriesList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productCategoriesEntityList)) {
            productCategoriesEntityList.forEach(productCategoriesFromDB -> {
                ManagerEntity managerEntity = new ManagerEntity();
                ProductCategories productcategories = new ProductCategories();
                BeanUtils.copyProperties(productCategoriesFromDB, productcategories);
                if (productCategoriesFromDB.getCreaterId() != null) {
                    managerEntity.setId(productCategoriesFromDB.getCreaterId());
                    ManagerEntity managerEntityFromDB = managerMapper.selectOne(managerEntity);
                    if (managerEntityFromDB != null) {
                        productcategories.setCreator(managerEntityFromDB.getSysName());
                    }
                }
                productcategoriesList.add(productcategories);
            });
            result.setData(productcategoriesList);
        }
        return result;
    }

    @Autowired
    ProductService productService;

    @Override
    public ProductCategoriesEntity update(ProductCategoriesEntity productCategoriesEntity) throws TipsException {
        if(productCategoriesEntity instanceof  ProductCategories){
            ProductCategories productCategories = (ProductCategories) productCategoriesEntity;
            if(productCategories.getPoint()!=null){
                Integer point = productCategories.getPoint();
                //更新下面所有的商品积分
                ProductEntity productEntity = new ProductEntity();
                productEntity.setCategoriesId(productCategories.getId());
                List<ProductEntity> productEntityList = productService.list(productEntity);
                if(!CollectionUtils.isEmpty(productEntityList)){
                    for (int i = 0; i < productEntityList.size(); i++) {
                        productEntityList.get(i).setPoint(point);
                        productService.update(productEntityList.get(i));
                    }
                }
            }
        }

        return super.update(productCategoriesEntity);
    }
}
