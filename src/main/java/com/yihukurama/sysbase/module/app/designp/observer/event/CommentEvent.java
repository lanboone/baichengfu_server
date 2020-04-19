package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.mapper.TopicCommentMapper;
import com.yihukurama.sysbase.model.TopicCommentEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.service.domainservice.TopicCommentService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;
/**
 * 说明： 评论事件
 * @author yihukurama
 * @date Created in 17:20 2020/4/19
 *       Modified by yihukurama in 17:20 2020/4/19
 */
public class CommentEvent extends ApplicationEvent {
    /**
     * 创建评论事件
     */
    public final static int TYPE_10 = 10;


    /**
     * 事件类型  10创建评论  20取消点赞
     */
    private Integer type;
    public CommentEvent(Object source) {
        super(source);
    }

    public CommentEvent(Object source,Integer type) {
        super(source);
        this.type = type;
    }

    public void handleEvent(){
        switch (type){
            case TYPE_10:
                createReply();
                break;
            default:
        }
    }

    private void createReply()  {
        if (!(source instanceof TopicCommentEntity)) {
            LogUtil.errorLog(this,"处理创建评论事件出错，事件源不是AppuserEntity");
            return;
        }
        TopicCommentEntity topicCommentEntity = (TopicCommentEntity) source;
        TopicCommentMapper topicCommentMapper = (TopicCommentMapper) SpringBeanTools.getBean(TopicCommentMapper.class);
        TopicCommentEntity parentComment = topicCommentMapper.selectByPrimaryKey(topicCommentEntity.getCParentId());
        parentComment.setReplyPath(topicCommentEntity.getId()+"/"+parentComment.getReplyPath());
        topicCommentMapper.updateByPrimaryKeySelective(parentComment);

    }



}
