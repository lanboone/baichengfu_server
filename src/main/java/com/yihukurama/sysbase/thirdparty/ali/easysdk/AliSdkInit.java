package com.yihukurama.sysbase.thirdparty.ali.easysdk;

import com.alibaba.fastjson.JSON;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.BaseClient.Config;
import com.lly835.bestpay.config.AliPayConfig;
import com.yihukurama.sysbase.thirdparty.ali.MyAlipayConfig;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： 阿里sdk初始化
 * @author yihukurama
 * @date Created in 14:10 2020/5/3
 *       Modified by yihukurama in 14:10 2020/5/3
 */
@Service
public class AliSdkInit {

    @Autowired
    MyAlipayConfig aliEasySDKConfig;

    public static boolean hasInit = false;
    public synchronized void init(){
        if(hasInit){
            return;
        }
        LogUtil.infoLog(AliSdkInit.class,"阿里 SDK初始化开始");
        Factory.setOptions(getOptions());
        LogUtil.infoLog(AliSdkInit.class,"阿里 SDK初始化完毕");
        hasInit = true;
    }

    private Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";
        config.gatewayHost = "https://openapi.alipay.com/gateway.do";
        // 请更换为您的AppId
        config.appId = aliEasySDKConfig.getAppId();
        // 请更换为您的PKCS8格式的应用私钥
        config.merchantPrivateKey = aliEasySDKConfig.getPrivateKey();
        // 如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = aliEasySDKConfig.getAliPayPublicKey();
        return config;
    }
}
