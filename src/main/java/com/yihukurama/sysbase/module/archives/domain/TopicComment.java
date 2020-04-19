package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.TopicCommentEntity;
import lombok.Data;

import java.util.List;

/**
 * 说明： 话题评论实体类
 * @author yihukurama
 * @date Created in 16:26 2020/4/19
 *       Modified by yihukurama in 16:26 2020/4/19
 */
@Data
public class TopicComment extends TopicCommentEntity {

    /**
     * 每个评论的回复展示数量
     */
    public static final int REPLY_SHOW_COUNT = 2;
    /**
     * 评论下的回复
     */
    private List<TopicCommentEntity> replyList;
}
