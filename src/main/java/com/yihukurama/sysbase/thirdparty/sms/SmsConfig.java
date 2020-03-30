package com.yihukurama.sysbase.thirdparty.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="sms")
@Data
public class SmsConfig{

    private String accesskey;
    private String secret;
}
