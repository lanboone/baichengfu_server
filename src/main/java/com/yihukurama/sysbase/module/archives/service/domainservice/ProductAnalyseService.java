package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.model.ProductAnalyseEntity;
import com.yihukurama.sysbase.module.archives.domain.ProductAnalyse;
import com.yihukurama.sysbase.module.archives.domain.ProductAnalyse.AnalyseData;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class ProductAnalyseService extends CrudService<ProductAnalyseEntity> {


    @Override
    public Result list(ProductAnalyseEntity productAnalyseEntity, Integer page, Integer limit) throws TipsException {
        if(productAnalyseEntity instanceof ProductAnalyse){
            ProductAnalyse productAnalyse = (ProductAnalyse) productAnalyseEntity;
            if(productAnalyse.getSearchType()!=null && productAnalyse.getSearchType() == ProductAnalyse.SEARCH_TYPE_10){
                Map<String,ProductAnalyseEntity> analyseEntityMap = new TreeMap<>();
                List<ProductAnalyseEntity> productAnalyseEntityList = super.list(productAnalyseEntity);
                if(!CollectionUtils.isEmpty(productAnalyseEntityList)){
                    for (int i = 0; i < productAnalyseEntityList.size(); i++) {
                        String productId = productAnalyseEntityList.get(i).getProductId();
                        if (analyseEntityMap.containsKey(productId)){
                            productAnalyseEntity = analyseEntityMap.get(productId);
                            productAnalyseEntity.setSoldNumCount(NumberUtil.NullPlus(productAnalyseEntity.getSoldNumCount(),1));
                            productAnalyseEntity.setSoldPriceCount(NumberUtil.NullPlus(productAnalyseEntity.getSoldPriceCount(),productAnalyseEntityList.get(i).getSoldPriceCount()));
                            productAnalyseEntity.setAvg(productAnalyseEntity.getSoldPriceCount()/productAnalyseEntity.getSoldNumCount());
                            analyseEntityMap.put(productId,productAnalyseEntity);
                        }else {
                            analyseEntityMap.put(productId,productAnalyseEntityList.get(i));
                        }
                    }
                    return Result.successed(analyseEntityMap);
                }
            }
        }

        return super.list(productAnalyseEntity, page, limit);
    }
}
