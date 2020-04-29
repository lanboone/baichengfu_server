package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.ProductstandardEntity;
import com.yihukurama.sysbase.model.StandardconfigEntity;
import com.yihukurama.sysbase.module.archives.domain.Product;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明： Product的领域服务
 *
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class ProductService extends CrudService<ProductEntity> {

    @Autowired
    ProductstandardService productstandardService;

    @Autowired
    StandardconfigService standardconfigService;

    @Override
    public Result list(ProductEntity productEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(productEntity, page, limit);
        List<ProductEntity> productEntities = (List<ProductEntity>) result.getData();
        List<Product> products = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productEntities)) {
            for (ProductEntity productEntityFromDB : productEntities) {
                Product product = new Product();
                BeanUtils.copyProperties(productEntityFromDB, product);
                String productId = productEntityFromDB.getId();

                ProductstandardEntity productstandardEntity = new ProductstandardEntity();
                productstandardEntity.setProductId(productId);
                List<ProductstandardEntity> productStandradList = productstandardService.list(productstandardEntity);
                product.setProductStandardEntityList(productStandradList);

                StandardconfigEntity standardconfigEntity = new StandardconfigEntity();
                standardconfigEntity.setProductId(productId);
                List<StandardconfigEntity> standardconfigEntityList = standardconfigService.list(standardconfigEntity);
                product.setStandardConfigEntityList(standardconfigEntityList);

                products.add(product);
            }
            result.setData(products);
        }
        return result;
    }


    @Override
    public ProductEntity create(ProductEntity productEntity) throws TipsException {
        if (productEntity instanceof Product) {
            List<ProductstandardEntity> productstandardEntityList =
                    ((Product) productEntity).getProductStandardEntityList();
            List<StandardconfigEntity> standardconfigEntityList =
                    ((Product) productEntity).getStandardConfigEntityList();
            productstandardService.creates(productstandardEntityList);
            standardconfigService.creates(standardconfigEntityList);
        }
        ProductEntity productEntityFromDB = super.create(productEntity);
        return productEntityFromDB;
    }

    @Override
    @Transient
    public ProductEntity load(ProductEntity productEntity) throws TipsException {
        ProductEntity productEntityFromDB = super.load(productEntity);
        if (productEntityFromDB != null) {
            Product product = new Product();
            BeanUtils.copyProperties(productEntityFromDB, product);
            String productId = productEntityFromDB.getId();

            ProductstandardEntity productstandardEntity = new ProductstandardEntity();
            productstandardEntity.setProductId(productId);
            List<ProductstandardEntity> productStandradList = productstandardService.list(productstandardEntity);
            product.setProductStandardEntityList(productStandradList);

            StandardconfigEntity standardconfigEntity = new StandardconfigEntity();
            standardconfigEntity.setProductId(productId);
            List<StandardconfigEntity> standardconfigEntityList = standardconfigService.list(standardconfigEntity);
            product.setStandardConfigEntityList(standardconfigEntityList);

            return product;
        }
        return productEntityFromDB;
    }

}
