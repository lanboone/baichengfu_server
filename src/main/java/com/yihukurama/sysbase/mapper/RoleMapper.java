package com.yihukurama.sysbase.mapper;

import com.yihukurama.sysbase.model.RoleEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 说明： RoleEntity的通用mapper接口
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@Repository
public interface RoleMapper extends Mapper<RoleEntity> {
}

