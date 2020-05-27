package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserTopicEntity;
import com.yihukurama.sysbase.model.TopicEntity;
import lombok.Data;

@Data
public class AppuserTopic extends AppuserTopicEntity {

    /**
     * 关联的话题
     */
    TopicEntity topicEntity;
}
