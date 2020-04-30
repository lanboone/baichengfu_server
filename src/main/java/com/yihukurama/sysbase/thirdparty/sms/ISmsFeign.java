package com.yihukurama.sysbase.thirdparty.sms;

import com.alibaba.fastjson.JSON;
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
@FeignClient(name = "sms", url = "http://api.1cloudsp.com/api/v2/", fallback= ISmsFeign.SmsFeignFallback.class)
public interface ISmsFeign {

    /**
     * 说明： 
     * @author yihukurama
     * @date Created in 20:48 2020/3/30
     *       Modified by yihukurama in 20:48 2020/3/30
     */
    @RequestMapping(value = "/single_send", method = RequestMethod.POST)
    String singleSend(@RequestParam String accesskey,
                      @RequestParam String secret,
                      @RequestParam String sign,
                      @RequestParam String templateId,
                      @RequestParam String mobile,
                      @RequestParam String content);
//    @RequestMapping(value = "/single_send", method = RequestMethod.POST)
//    String singleSend(@RequestBody String body);

    @Component
    class SmsFeignFallback implements  ISmsFeign{

        @Override
        public String singleSend(String accesskey, String secret, String sign, String templateId, String mobile, String content) {
            LogUtil.errorLog(this,"发送短信失败");
            return null;
        }
    }
}
