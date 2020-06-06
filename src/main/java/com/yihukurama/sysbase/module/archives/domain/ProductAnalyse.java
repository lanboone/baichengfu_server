package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductAnalyseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductAnalyse extends ProductAnalyseEntity {

    public class AnalyseData extends ProductAnalyseEntity{
        @Override
        public boolean equals(Object o) {
            if(o instanceof AnalyseData){
                AnalyseData analyseData = (AnalyseData) o;
                if(analyseData.getProductId().equals(((AnalyseData) o).getProductId())){
                    return true;
                }else{
                    return false;
                }
            }
            return super.equals(o);
        }

    }
    public static final int SEARCH_TYPE_10 = 10;

    /**
     * 搜索条件   10按商品搜索统计
     */
    @ApiModelProperty(value = "搜索条件   10按商品搜索统计")
    private Integer searchType;

}
