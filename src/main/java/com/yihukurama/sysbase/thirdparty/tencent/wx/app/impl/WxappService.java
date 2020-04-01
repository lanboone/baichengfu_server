package com.yihukurama.sysbase.thirdparty.tencent.wx.app.impl;

import com.yihukurama.sysbase.thirdparty.tencent.wx.app.IWxapp;
import com.yihukurama.sysbase.thirdparty.tencent.wx.app.IWxappFeign;
import com.yihukurama.sysbase.thirdparty.tencent.wx.app.WxappConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxappService implements IWxapp {

    @Autowired
    WxappConfig wxappConfig;


    @Autowired
    IWxappFeign iWxappFeign;

    @Override
    public String doGetAccessToken(String code) {


        String result = iWxappFeign.access_token(wxappConfig.getAppId(),
                wxappConfig.getAppSecret(),code,null);

        return null;
    }
}
