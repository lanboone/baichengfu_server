package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.controller.app.dto.CommentChildrenDto;
import com.yihukurama.sysbase.model.TopicCommentEntity;
import com.yihukurama.sysbase.module.app.ITopic;
import com.yihukurama.sysbase.module.archives.domain.TopicComment;
import com.yihukurama.sysbase.module.archives.service.domainservice.TopicCommentService;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicImpl implements ITopic {

    @Autowired
    TopicCommentService topicCommentService;

    @Override
    public Result refreshCommentList(Request<CommentChildrenDto> request) throws TipsException {
        List<TopicComment> topicCommentList = request.getData().getTopicCommentList();
        for (int i = 0; i < topicCommentList.size(); i++) {
            TopicComment topicComment = topicCommentList.get(i);
            List<TopicCommentEntity> replyList = new ArrayList<>();
            //获取该评论的回复路劲，只加载两条
            String replyPath = topicComment.getReplyPath();
            String[] replyIds = replyPath.split("/");
            if(replyIds != null && replyIds.length>0){
                for (int j = 0; j < replyIds.length; j++) {
                    //回复只展示最新n条
                    if(j == TopicComment.REPLY_SHOW_COUNT || replyIds[j].length()!=32){
                        break;
                    }
                    String replyId = replyIds[j];
                    TopicCommentEntity topicCommentEntity = new TopicCommentEntity();
                    topicCommentEntity.setId(replyId);
                    topicCommentEntity = topicCommentService.load(topicCommentEntity);
                    replyList.add(topicCommentEntity);
                }
            }
            topicComment.setReplyList(replyList);
        }
        return Result.successed(topicCommentList);
    }
}
