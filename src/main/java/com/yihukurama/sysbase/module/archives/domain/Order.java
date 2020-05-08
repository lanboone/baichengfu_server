package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserShopcarEntity;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Order extends OrderEntity {

    /**
     *订单状态（10待支付、20待发货、30待收货、40待评价、50待退款、60已退款）
     */
    public static final int PAY_STATUS_10 = 10;
    public static final int PAY_STATUS_20 = 20;
    public static final int PAY_STATUS_30 = 30;
    public static final int PAY_STATUS_40 = 40;
    public static final int PAY_STATUS_50 = 50;
    public static final int PAY_STATUS_60 = 60;

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
