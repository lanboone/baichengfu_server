package com.yihukurama.sysbase.mapper;

import com.yihukurama.sysbase.model.ProductstandardEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: liyuan
 * @date: 2020/4/27 23:38
 * @description: ProductstandardEntity通用接口
 */
@Repository
public interface ProductstandardMapper  extends Mapper<ProductstandardEntity> {
}
