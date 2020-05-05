package com.yihukurama.sysbase.thirdparty.tencent.wx.pay;


import com.lly835.bestpay.config.WxPayConfig;
import com.yihukurama.tkmybatisplus.thirdparty.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="wxpayconfig")
@Data
public class WxPaySDKConfig extends WxPayConfig {


}
