package com.yihukurama.sysbase.module.im.impl;

import com.alibaba.fastjson.JSON;
import com.yihukurama.sysbase.model.AppuserMsgEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserMaster;
import com.yihukurama.sysbase.module.archives.domain.AppuserMsg;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserMsgService;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserService;
import com.yihukurama.sysbase.module.im.IMqtt;
import com.yihukurama.sysbase.module.im.IMqttSender;
import com.yihukurama.sysbase.module.im.TopicInfo;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yihukurama.sysbase.common.Cache.topicInfoSet;

@Service
public class MqttService implements IMqtt {

    /**
     * 注入发送MQTT的Bean
     */
    @Autowired
    private IMqttSender iMqttSender;

    @Autowired
    private AppuserMsgService appuserMsgService;


    @Override
    public Result sendMsg(Request<AppuserMsg> request) throws TipsException {
        AppuserMsg appuserMsg = request.getData();
        String topic = appuserMsg.getMsgTopic();

        AppuserMsgEntity appuserMsgEntity = appuserMsgService.create(appuserMsg);
        if(appuserMsgEntity!=null){
            TopicInfo topicInfo = new TopicInfo();
            topicInfo.setMsgTopic(appuserMsg.getMsgTopic());
            topicInfo.setMsgTopicName(appuserMsg.getMsgTopicName());
            if(appuserMsgEntity.getSenderId()!=null && appuserMsgEntity.getReceiverId()!=null){
                topicInfo.setStatus(TopicInfo.CHATING);
            }else{
                topicInfo.setStatus(TopicInfo.CHATING);
            }
            //放入当前主题
            topicInfoSet.add(topicInfo);
            iMqttSender.sendToMqtt(topic, JSON.toJSONString(appuserMsg));
            return Result.successed("发送成功");
        }
        return Result.failed("发送失败");
    }
}
