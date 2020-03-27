package com.yihukurama.sysbase.thirdparty.sms.impl;

import com.yihukurama.sysbase.thirdparty.sms.ISms;
import org.springframework.stereotype.Service;

@Service
public class Sms implements ISms {
    @Override
    public String sendSms(String phoneNum, String content) {
        return null;
    }
}
