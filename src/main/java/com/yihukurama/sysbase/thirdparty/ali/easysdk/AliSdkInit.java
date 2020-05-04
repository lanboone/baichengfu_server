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
        // 如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = aliEasySDKConfig.getAlipayPublicKey();
        return config;
    }
}
