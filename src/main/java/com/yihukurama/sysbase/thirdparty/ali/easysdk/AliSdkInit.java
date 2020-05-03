package com.yihukurama.sysbase.thirdparty.ali.easysdk;

import com.alibaba.fastjson.JSON;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.BaseClient.Config;
import com.mysql.cj.util.LogUtils;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
/**
 * 说明： 阿里sdk初始化
 * @author yihukurama
 * @date Created in 14:10 2020/5/3
 *       Modified by yihukurama in 14:10 2020/5/3
 */
public class AliSdkInit {

    public static void init(){
        LogUtil.infoLog(AliSdkInit.class,"阿里 SDK初始化开始");
        Factory.setOptions(getOptions());
        LogUtil.infoLog(AliSdkInit.class,"阿里 SDK初始化完毕");
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";


        AliEasySDKConfig aliEasySDKConfig = (AliEasySDKConfig) SpringBeanTools.getBean(AliEasySDKConfig.class);
        LogUtil.debugLog(AliSdkInit.class, "获取的alieasysdk配置是："+JSON.toJSONString(aliEasySDKConfig));

        // 请更换为您的AppId
        config.appId = aliEasySDKConfig.getAppid();
        // 请更换为您的应用公钥证书文件路径
        config.merchantCertPath = aliEasySDKConfig.getMerchantCertPath();
        // 请更换为您的支付宝公钥证书文件路径
        config.alipayCertPath = aliEasySDKConfig.getAlipayCertPath();
        // 请更换为您的支付宝根证书文件路径
        config.alipayRootCertPath = aliEasySDKConfig.getAlipayRootCertPath();
        // 请更换为您的PKCS8格式的应用私钥
        config.merchantPrivateKey = aliEasySDKConfig.getMerchantPrivateKey();

        // 如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        // config.alipayPublicKey = "MIIBIjANBg...";
        return config;
    }
}
