package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.ProductStandardEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.sysbase.module.archives.domain.AppuserShopcar;
import com.yihukurama.sysbase.module.archives.domain.Product;
import com.yihukurama.sysbase.module.archives.domain.ProductStandard;
import com.yihukurama.sysbase.module.archives.domain.StandardConfig;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    ProductStandardService productstandardService;

    @Autowired
    StandardConfigService standardconfigService;

    @Override
    public Result list(ProductEntity productEntity, Integer page, Integer limit) throws TipsException {
        if(productEntity instanceof Product){
            Product product = (Product) productEntity;
            String searchCategoriesIds = product.getSearchCategoriesIds();
            String whereSql = "";
            if (!EmptyUtil.isEmpty(product.getKeyWords())) {
                whereSql = "(product_name like '%s' or locate(product_name,'%s')>0 or categorie_name like '%s' or locate(categorie_name,'%s')>0 )";
                whereSql = String.format(whereSql, "%" + product.getKeyWords() + "%",product.getKeyWords(),"%" + product.getKeyWords() + "%",product.getKeyWords() );
                product.setWhereSql(whereSql);
            }
            if (!EmptyUtil.isEmpty(searchCategoriesIds)) {
                String categoriesIds[] = searchCategoriesIds.split(";");
                for (int i = 0; i < categoriesIds.length; i++) {
                    if (!EmptyUtil.isEmpty(whereSql)) {
                        whereSql = whereSql + " or categories_id = '" + categoriesIds[i] + "'";
                    } else {
                        whereSql = "categories_id = '" + categoriesIds[i] + "'";
                    }
                }
            }
            product.setWhereSql(whereSql);
            product.setSortSql("recommend_sort desc,create_date desc");
            if(product.getSearchType()!=null){
                if(product.getSearchType() == Product.SEARCH_TYPE_10){
                    product.setSortSql("order_count desc,create_date desc");
                }else if(product.getSearchType() == Product.SEARCH_TYPE_20){
                    product.setSortSql("sales_volume desc,create_date desc");
                }else if(product.getSearchType() == Product.SEARCH_TYPE_30){
                    product.setSortSql("favorite_number desc,create_date desc");
                }else if(product.getSearchType() == Product.SEARCH_TYPE_40){
                    product.setSortSql("ref_price asc,create_date desc");
                }else if(product.getSearchType() == Product.SEARCH_TYPE_50){
                    product.setSortSql("ref_price desc,create_date desc");
                }

            }


        }
        return super.list(productEntity, page, limit);
    }


    @Transactional
    @Override
    public ProductEntity create(ProductEntity productEntity) throws TipsException {
        ProductEntity productEntityFromDB = null;
        if (productEntity instanceof Product) {
            List<ProductStandardEntity> productstandardEntityList =
                    ((Product) productEntity).getProductStandardEntityList();
            List<StandardConfigEntity> standardconfigEntityList =
                    ((Product) productEntity).getStandardConfigEntityList();

            if(EmptyUtil.isEmpty(productstandardEntityList) || EmptyUtil.isEmpty(standardconfigEntityList)){
                throw new TipsException("创建商品必须要有规格和规格明细");
            }

            productEntityFromDB = super.create(productEntity);

            for (int i = 0; i < productstandardEntityList.size(); i++) {
                productstandardEntityList.get(i).setProductId(productEntityFromDB.getId());
            }
            for (StandardConfigEntity standardConfig:standardconfigEntityList
                 ) {
                if(standardConfig == null || standardConfig.getPrice() == null){
                    throw new TipsException("创建商品时具体规格商品价格必须要价格");
                }
                standardConfig.setProductId(productEntityFromDB.getId());
            }
            productstandardService.creates(productstandardEntityList);
            standardconfigService.creates(standardconfigEntityList);
        }

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
            ProductStandardEntity productstandardEntity = new ProductStandardEntity();
            productstandardEntity.setProductId(productId);
            List<ProductStandardEntity> productStandradList = productstandardService.list(productstandardEntity);
            product.setProductStandardEntityList(productStandradList);

            StandardConfigEntity standardconfigEntity = new StandardConfigEntity();
            standardconfigEntity.setProductId(productId);
            List<StandardConfigEntity> standardconfigEntityList = standardconfigService.list(standardconfigEntity);
            product.setStandardConfigEntityList(standardconfigEntityList);

            return product;
        }
        return productEntityFromDB;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductEntity update(ProductEntity productEntity) throws TipsException {
        ProductEntity productEntityFromDB = super.update(productEntity);
        if (productEntity instanceof Product) {
            List<ProductStandardEntity> productstandardEntityList =
                    ((Product) productEntity).getProductStandardEntityList();
            List<StandardConfigEntity> standardconfigEntityList =
                    ((Product) productEntity).getStandardConfigEntityList();

            if(EmptyUtil.isEmpty(productstandardEntityList) || EmptyUtil.isEmpty(standardconfigEntityList)){
                //若传进来的是null则不更新,规格
                return productEntityFromDB;
            }

            //删除原规格和规格明细
            ProductStandardEntity productStandardEntity = new ProductStandardEntity();
            productStandardEntity.setProductId(productEntity.getId());
            List<ProductStandardEntity> productStandardEntities =  productstandardService.list(productStandardEntity);
            for (int i = 0; i < productStandardEntities.size(); i++) {
                productstandardService.remove(productStandardEntities.get(i));
            }

            StandardConfigEntity standardConfigEntity = new StandardConfigEntity();
            standardConfigEntity.setProductId(productEntity.getId());
            List<StandardConfigEntity> standardConfigEntities = standardconfigService.list(standardConfigEntity);
            for (int i = 0; i < standardConfigEntities.size(); i++) {
                standardconfigService.remove(standardConfigEntities.get(i));
            }


            for (int i = 0; i < productstandardEntityList.size(); i++) {
                productstandardEntityList.get(i).setProductId(productEntityFromDB.getId());
            }
            for (StandardConfigEntity standardConfig:standardconfigEntityList
            ) {
                if(standardConfig == null || standardConfig.getPrice() == null){
                    throw new TipsException("创建商品时具体规格商品价格必须要价格");
                }
                standardConfig.setProductId(productEntityFromDB.getId());
            }
            productstandardService.creates(productstandardEntityList);
            standardconfigService.creates(standardconfigEntityList);
        }

        return productEntityFromDB;

    }
}
