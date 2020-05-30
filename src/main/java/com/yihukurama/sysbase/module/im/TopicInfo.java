package com.yihukurama.sysbase.module.im;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TopicInfo {
    /**
     * 等待客服连接
     */
    public static int WAIT_CHAT = 10;

    /**
     * 聊天中
     */
    public static int CHATING = 20;


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

    /**
     * 10 等待客服接入  20聊天中
     */
    @ApiModelProperty(value="10 等待客服接入  20聊天中")
    Integer status;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TopicInfo){
            if(msgTopic.equals(obj)){
                return true;
            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}
