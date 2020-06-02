package com.yihukurama.sysbase.module.im.config;

import com.alibaba.fastjson.JSON;
import com.yihukurama.sysbase.model.AppuserMsgEntity;
import com.yihukurama.sysbase.module.archives.domain.AppuserMsg;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserMsgService;
import com.yihukurama.sysbase.module.im.TopicInfo;
import com.yihukurama.sysbase.module.im.websocket.WebSocket;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import sun.rmi.runtime.Log;

import static com.yihukurama.sysbase.common.Cache.topicInfoSet;

/**
 * MQTT配置，消费者
 */
@Configuration
public class MqttReceiverConfig {
    /**
     * 订阅的bean名称
     */
    public static final String CHANNEL_NAME_IN = "mqttInboundChannel";

    // 客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息
    private static final byte[] WILL_DATA;

    static {
        WILL_DATA = "offline".getBytes();
    }

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.url}")
    private String url;

    @Value("${mqtt.receiver.clientId}")
    private String clientId;

    @Value("${mqtt.receiver.defaultTopic}")
    private String defaultTopic;

    /**
     * MQTT连接器选项
     */
    @Bean
    public MqttConnectOptions getReceiverMqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        // 设置连接的用户名
        if (!username.trim().equals("")) {
            options.setUserName(username);
        }
        // 设置连接的密码
        options.setPassword(password.toCharArray());
        // 设置连接的地址
        options.setServerURIs(StringUtils.split(url, ","));
        // 设置超时时间 单位为秒
        options.setConnectionTimeout(10);
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线
        // 但这个方法并没有重连的机制
        options.setKeepAliveInterval(20);
        return options;
    }

    /**
     * MQTT客户端
     */
    @Bean
    public MqttPahoClientFactory receiverMqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getReceiverMqttConnectOptions());
        return factory;
    }

    /**
     * MQTT信息通道（消费者）
     */
    @Bean(name = CHANNEL_NAME_IN)
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }


    /**
     * MQTT消息订阅绑定（消费者）
     */
    @Bean
    public MessageProducer inbound() {
        // 可以同时消费（订阅）多个Topic
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        clientId, receiverMqttClientFactory(),
                        StringUtils.split(defaultTopic, ","));
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        // 设置订阅通道
        adapter.setOutputChannel(mqttInboundChannel());
        return adapter;
    }

    @Autowired
    AppuserMsgService appuserMsgService;
    /**
     * MQTT消息处理器（消费者）
     */
    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_IN)
    public MessageHandler handler() {
        return new MessageHandler() {
            @SneakyThrows
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
                String msg = message.getPayload().toString();
                AppuserMsg appuserMsg = JSON.parseObject(msg, AppuserMsg.class);
                if (appuserMsg == null) {
                    LogUtil.errorLog(this, "mqtt接收到不明消息");
                    return;
                }
                appuserMsgService.create((AppuserMsgEntity) appuserMsg);
                int send_type = appuserMsg.getSenderType();
                switch (send_type) {
                    case 10:
                        LogUtil.infoLog(this, "发给app的信息");
                        break;
                    case 20:
                        LogUtil.infoLog(this, "发给后台的信息");
                        if (appuserMsg.getReceiverId() == null) {
                            //放入会话列表
                            TopicInfo topicInfo = new TopicInfo();
                            topicInfo.setMsgTopic(appuserMsg.getMsgTopic());
                            topicInfo.setMsgTopicName(appuserMsg.getMsgTopicName());
                            topicInfo.setStatus(TopicInfo.WAIT_CHAT);
                            //放入会话
                            topicInfoSet.add(topicInfo);
                        } else {
                            //通过websocket发送
                            WebSocket.sendMsgByUserId(JSON.toJSONString(appuserMsg),appuserMsg.getReceiverId());
                            TopicInfo topicInfo = new TopicInfo();
                            topicInfo.setMsgTopic(appuserMsg.getMsgTopic());
                            topicInfo.setMsgTopicName(appuserMsg.getMsgTopicName());
                            topicInfo.setStatus(TopicInfo.CHATING);
                            //更新会话
                            topicInfoSet.add(topicInfo);
                        }
                        break;
                    default:
                        LogUtil.errorLog(this, "无法处理的消息");
                }
            }
        };
    }
}