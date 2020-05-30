package com.yihukurama.sysbase.controller;

import com.alibaba.fastjson.JSON;
import com.yihukurama.sysbase.common.Cache;
import com.yihukurama.sysbase.controller.dto.EmsSearchDto;
import com.yihukurama.sysbase.module.archives.domain.AppuserMsg;
import com.yihukurama.sysbase.module.im.IMqtt;
import com.yihukurama.sysbase.module.im.IMqttSender;
import com.yihukurama.sysbase.module.im.TopicInfo;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yihukurama.sysbase.common.Cache.topicInfoSet;

@RestController
public class ImController
{

    @Autowired
    IMqtt iMqtt;

    @ApiOperation(value = "发送IM信息接口", notes = "发送IM信息接口")
    @RequestMapping(value = "/send_msg", method = RequestMethod.POST)
    public Result sendMsg(@RequestBody Request<AppuserMsg> request) throws TipsException {
        return  iMqtt.sendMsg(request);
    }

    @ApiOperation(value = "获取聊天主题列表", notes = "获取聊天主题列表")
    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public Result topics(@RequestBody Request<AppuserMsg> request) throws TipsException {

        return Result.successed(Cache.topicInfoSet);
    }


    @ApiOperation(value = "结束聊天，将从话题列表移除", notes = "结束聊天，将从话题列表移除")
    @RequestMapping(value = "/end_chat", method = RequestMethod.POST)
    public Result end_chat(@RequestBody Request<AppuserMsg> request) throws TipsException {
        AppuserMsg appuserMsg = request.getData();

        TopicInfo topicInfo = new TopicInfo();
        topicInfo.setMsgTopic(appuserMsg.getMsgTopic());
        topicInfo.setMsgTopicName(appuserMsg.getMsgTopicName());
        //移除会话
        topicInfoSet.remove(topicInfo);
        return Result.successed(Cache.topicInfoSet);
    }
}
