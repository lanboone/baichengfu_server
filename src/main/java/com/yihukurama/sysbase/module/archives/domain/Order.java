package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserShopcarEntity;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
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
     * 支付宝下单时需要上传购买者id
     */
    @ApiModelProperty(value="支付宝下单时需要上传购买者id")
    private String buyerId;
    /**
     * 带出订单商品列表
     */
    public static int SEARCH_TYPE_10  = 10;
    @ApiModelProperty(value="创建订单时关联的商品")
    List<OrderProductEntity> orderProducts;

    /**
     * 查询时 大于等于该时间
     */
    @ApiModelProperty(value = "查询时 大于等于该时间")
    private Date gtCreateDate;
    /**
     * 查询时 小于等于该时间
     */
    @ApiModelProperty(value = "查询时 小于等于该时间")
    private Date ltCreateDate;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GT,proprtityName = "create_date")
    public Date getGtCreateDate() {
        return gtCreateDate;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LT,proprtityName = "create_date")
    public Date getLtCreateDate() {
        return ltCreateDate;
    }

}
