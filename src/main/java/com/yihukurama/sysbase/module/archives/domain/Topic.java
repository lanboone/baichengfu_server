package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.TopicEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import lombok.Data;

@Data
public class Topic extends TopicEntity {

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "topic_title")
    @Override
    public String getTopicTitle() {
        return super.getTopicTitle();
    }

}
