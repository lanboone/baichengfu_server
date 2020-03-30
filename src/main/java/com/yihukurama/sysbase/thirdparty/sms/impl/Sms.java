package com.yihukurama.sysbase.thirdparty.sms.impl;

import com.alibaba.fastjson.JSONObject;
import com.yihukurama.sysbase.thirdparty.sms.ISms;
import com.yihukurama.sysbase.thirdparty.sms.ISmsFeign;
import com.yihukurama.sysbase.thirdparty.sms.SmsConfig;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sms implements ISms {

    @Autowired
    ISmsFeign iSmsFeign;
    @Autowired
    SmsConfig smsConfig;

    @Override
    public String sendCheckSms(String phoneNum, String content)
    {

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("accesskey",smsConfig.getAccesskey());
        jsonBody.put("secret",smsConfig.getSecret());
        jsonBody.put("sign","145534");
        jsonBody.put("templateId","180197");
        jsonBody.put("mobile",phoneNum);
        jsonBody.put("content",content);
//        String result = iSmsFeign.singleSend(jsonBody.toString());
        String result = iSmsFeign.singleSend(smsConfig.getAccesskey(),
                smsConfig.getSecret(),
                "145534",
                "180197",
                phoneNum,
                content);
        LogUtil.debugLog(this,result);
        return result;
    }
}
