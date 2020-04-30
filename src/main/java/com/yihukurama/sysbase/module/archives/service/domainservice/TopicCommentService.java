package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.TopicCommentEntity;
import com.yihukurama.sysbase.module.app.designp.observer.AppEventPublisher;
import com.yihukurama.sysbase.module.app.designp.observer.event.CommentEvent;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TopicCommentService extends CrudService<TopicCommentEntity> {

    @Autowired
    AppEventPublisher appEventPublisher;

    @Override
    public TopicCommentEntity create(TopicCommentEntity topicCommentEntity) throws TipsException {
        if (EmptyUtil.isEmpty(topicCommentEntity.getCommentName())
                || EmptyUtil.isEmpty(topicCommentEntity.getCreaterId())
                || EmptyUtil.isEmpty(topicCommentEntity.getCommentContent())
                || EmptyUtil.isEmpty(topicCommentEntity.getTopicId())
                || EmptyUtil.isEmpty(topicCommentEntity.getCParentId())
        ) {
            throw new TipsException("发表评论时昵称、创建人id、话题id、评论内容、父评论id不可为空");
        }



        topicCommentEntity = super.create(topicCommentEntity);


        //创建评论时如果是评论的回复，则需要写入父评论的reply_path
        if(topicCommentEntity.getCParentId().length() == 32){
            LogUtil.debugLog(this,"into comment event");
            appEventPublisher.publishEvent(new CommentEvent(topicCommentEntity,CommentEvent.TYPE_10));
        }
        return topicCommentEntity;
    }
}
