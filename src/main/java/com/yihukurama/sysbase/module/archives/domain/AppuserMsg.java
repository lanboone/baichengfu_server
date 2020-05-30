package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserMsgEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AppuserMsg extends AppuserMsgEntity {

    /**
     * 聊天时的主题，app用户id+商品id/订单id
     */
    @ApiModelProperty(value="聊天时的主题")
    String msgTopic;

    /**
     * 聊天时的主题名，如  商品名/订单号+用户昵称
     */
    @ApiModelProperty(value="聊天时的主题名，如  商品名/订单号+用户昵称")
    String msgTopicName;
}
