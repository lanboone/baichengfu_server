package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.TopicCommentEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
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

    @SqlWhere(value = SqlWhere.SqlWhereValue.LIKE,proprtityName = "topic_title")
    @Override
    public String getTopicTitle() {
        return super.getTopicTitle();
    }

    /**
     * 查询时 大于等于该时间
     */
    @ApiModelProperty(value = "查询时 大于等于该时间")
    private Date gtCreateDate;
    /**
     * 查询时 小于等于该时间
     */
    @ApiModelProperty(value = "查询时 小于等于该时间")
    private Date ltCreateDate;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GT,proprtityName = "create_date")
    public Date getGtCreateDate() {
        return gtCreateDate;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LT,proprtityName = "create_date")
    public Date getLtCreateDate() {
        return ltCreateDate;
    }

}
