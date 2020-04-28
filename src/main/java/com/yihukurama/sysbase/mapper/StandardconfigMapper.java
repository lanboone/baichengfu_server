package com.yihukurama.sysbase.mapper;

import com.yihukurama.sysbase.model.StandardconfigEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: liyuan
 * @date: 2020/4/28 23:39
 * @description: StandardconfigEntity通用接口
 */
@Repository
public interface StandardconfigMapper  extends Mapper<StandardconfigEntity> {
}
