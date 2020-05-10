package com.yihukurama.sysbase.bean;

import com.lly835.bestpay.config.AliPayConfig;
import com.yihukurama.sysbase.thirdparty.ali.easysdk.AliSdkInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * 说明： 系统启动时进行各种初始化
 * @author yihukurama
 * @date Created in 14:28 2020/5/10
 *       Modified by yihukurama in 14:28 2020/5/10
 */
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    AliSdkInit aliSdkInit;

    @Override
    public void run(String... args) throws Exception {
        aliSdkInit.init();
    }
}
