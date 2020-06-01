package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserTopicEntity;
import com.yihukurama.sysbase.model.TopicEntity;
import lombok.Data;

@Data
public class AppuserTopic extends AppuserTopicEntity {

    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;
    /**
     * 关联的话题
     */
    TopicEntity topicEntity;
}
