package com.yihukurama.sysbase.thirdparty.tencent.wx.app;

import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 说明： 微信公众号feign
 * @author: ouyaokun
 * @date: Created in 16:08 2019/3/18
 * @modified: by autor in 16:08 2019/3/18
 */
@FeignClient(name = "wxapp", url = "https://api.weixin.qq.com/sns/oauth2", fallback= IWxappFeign.WxappFeignFallback.class)
public interface IWxappFeign {

    /**
     * 说明： 
     * @author yihukurama
     * @date Created in 20:48 2020/3/30
     *       Modified by yihukurama in 20:48 2020/3/30
     */
    @RequestMapping(value = "/access_token", method = RequestMethod.POST)
    String access_token(@RequestParam String appid,
                      @RequestParam String secret,
                      @RequestParam String code,
                      @RequestParam (defaultValue = "authorization_code")String grant_type);

    @Component
    class WxappFeignFallback implements IWxappFeign {


        @Override
        public String access_token(String appid, String secret, String code, String grant_type) {
            LogUtil.errorLog(this,"获取微信accesstoken失败");
            return null;
        }
    }
}
