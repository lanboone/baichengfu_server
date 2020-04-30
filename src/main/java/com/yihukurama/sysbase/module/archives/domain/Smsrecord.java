package com.yihukurama.sysbase.module.archives.domain;


import com.yihukurama.sysbase.model.SmsrecordEntity;

/**
 * 说明： SmsrecordEntity的领域对象
 * @author: ouyaokun
 * @date: Created in 17:10 2018/4/28
 * @modified: by autor in 17:10 2018/4/28
 */
public class Smsrecord extends SmsrecordEntity {


    /**
     * 状态 1未发送
     */
    public static final int STATUS_1 = 1;

    /**
     * 状态 2发送成功
     */
    public static final int STATUS_2 = 2;

    /**
     * 状态 3发送失败
     */
    public static final int STATUS_3 = 3;
}
