package com.yihukurama.sysbase.mapper;

import com.yihukurama.sysbase.model.ProductStandardEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 说明： ProductStandardEntity的通用mapper接口
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@Repository
public interface ProductStandardMapper extends Mapper<ProductStandardEntity> {
}

