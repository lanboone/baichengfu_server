package com.yihukurama.sysbase.controller.app.dto;

import lombok.Data;

/**
 * 说明： 个人中心的数量显示
 * @author yihukurama
 * @date Created in 22:30 2020/5/11
 *       Modified by yihukurama in 22:30 2020/5/11
 */
@Data
public class PersonCountDto {

    /**
     * 待支付
     */
    Integer waitPay;
    /**
     * 待发货
     */
    Integer waitSend;
    /**
     * 待收货
     */
    Integer waitReceive;
    /**
     * 待评论
     */
    Integer waitComment;
    /**
     * 待退款
     */
    Integer waitRefund;
}
