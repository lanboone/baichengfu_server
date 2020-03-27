package com.yihukurama.sysbase.thirdparty.sms;
/**
 * 说明： 发送短信
 * @author yihukurama
 * @date Created in 13:34 2020/3/27
 *       Modified by yihukurama in 13:34 2020/3/27
 */
public interface ISms {


    String sendSms(String phoneNum,String content);
}
