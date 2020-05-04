package com.yihukurama.sysbase.thirdparty.ali.easysdk;


import com.yihukurama.tkmybatisplus.thirdparty.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="alieasysdk")
@Data
public class AliEasySDKConfig extends Config {

    private String alipayPublicKey;
}
