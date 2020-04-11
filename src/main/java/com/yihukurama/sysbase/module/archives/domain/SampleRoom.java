package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import lombok.Data;

import java.util.List;

/**
 * 说明： 样板间实体类
 * @author yihukurama
 * @date Created in 11:04 2020/4/11
 *       Modified by yihukurama in 11:04 2020/4/11
 */
@Data
public class SampleRoom extends SampleRoomEntity {

    /**
     * 样板间关联的商品
     */
    private List<ProductEntity> productEntityList;




}
