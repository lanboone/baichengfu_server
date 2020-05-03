package com.yihukurama.sysbase.thirdparty.ali.easysdk;


import com.yihukurama.tkmybatisplus.thirdparty.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="alieasysdk")
@Data
public class AliEasySDKConfig extends Config {

    // 应用公钥证书文件路径
    private String merchantCertPath;
    // 支付宝公钥证书文件路径
    private String alipayCertPath;
    // 支付宝根证书文件路径
    private String alipayRootCertPath;
    // PKCS8格式的应用私钥
    private String merchantPrivateKey;

}
