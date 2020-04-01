package com.yihukurama.sysbase.thirdparty.tencent.wx.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="wxapp")
@Data
public class WxappConfig {

    private String appId;
    private String appSecret;
}
