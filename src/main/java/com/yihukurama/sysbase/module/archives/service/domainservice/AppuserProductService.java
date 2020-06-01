package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.AppuserProductEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserProduct;
import com.yihukurama.sysbase.module.archives.domain.AppuserSample;
import com.yihukurama.sysbase.module.archives.domain.AppuserTopic;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class AppuserProductService extends CrudService<AppuserProductEntity> {


    @Autowired
    ProductService productService;

    @Override
    public Result list(AppuserProductEntity appuserProductEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(appuserProductEntity, page, limit);
        if(appuserProductEntity instanceof AppuserProduct){
            AppuserProduct appuserProduct  = (AppuserProduct) appuserProductEntity;
            if(appuserProduct.getSearchType() == AppuserProduct.SEARCH_TYPE_10){
                return result;
            }
            List<AppuserProductEntity> appuserProductEntityList = (List<AppuserProductEntity>) result.getData();
            List<AppuserProduct> appuserProductList = TransferUtils.transferEntityList2DomainList(appuserProductEntityList,AppuserProduct.class);
            if(!CollectionUtils.isEmpty(appuserProductEntityList)){
                for (int i = 0; i < appuserProductList.size(); i++) {
                    String proId = appuserProductList.get(i).getProductId();
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.setId(proId);
                    productEntity = productService.load(productEntity);
                    appuserProductList.get(i).setProductEntity(productEntity);
                }
            }
            result.setData(appuserProductList);
        }
        return  result;
    }
}
