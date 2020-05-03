package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Order extends OrderEntity {

    /**
     * 查询方式 10带出订单商品列表
     */
    private Integer searchType;
    /**
     * 带出订单商品列表
     */
    public static int SEARCH_TYPE_10  = 10;
    @ApiModelProperty(value="创建订单时关联的商品")
    List<OrderProductEntity> orderProducts;
}
