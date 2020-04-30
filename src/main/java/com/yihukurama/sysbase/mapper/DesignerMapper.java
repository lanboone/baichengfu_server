package com.yihukurama.sysbase.mapper;

import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.sysbase.module.archives.domain.Designer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 说明： DesignerEntity的通用mapper接口
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@Repository
public interface DesignerMapper extends Mapper<DesignerEntity> {

    /**
     * 根据关键字模糊搜索设计师名或者是风格
     * @return
     */
    List<DesignerEntity> selectByKeyWords(Designer designer);
}

