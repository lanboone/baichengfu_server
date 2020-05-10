package com.yihukurama.sysbase.bean;

import com.lly835.bestpay.config.AliPayConfig;
import com.yihukurama.sysbase.thirdparty.ali.easysdk.AliSdkInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    AliSdkInit aliSdkInit;

    @Override
    public void run(String... args) throws Exception {
        aliSdkInit.init();
    }
}
