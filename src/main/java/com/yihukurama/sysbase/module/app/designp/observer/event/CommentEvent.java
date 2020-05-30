package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.alibaba.fastjson.JSON;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.ProductCommentMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.mapper.TopicCommentMapper;
import com.yihukurama.sysbase.model.ProductCommentEntity;
import com.yihukurama.sysbase.model.TopicCommentEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.service.domainservice.TopicCommentService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import io.swagger.models.properties.EmailProperty;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明： 评论事件
 * @author yihukurama
 * @date Created in 17:20 2020/4/19
 *       Modified by yihukurama in 17:20 2020/4/19
 */
public class CommentEvent extends ApplicationEvent {
    /**
     * 创建话题评论事件
     */
    public final static int TYPE_10 = 10;


    /**
     * 创建商品评论事件
     */
    public final static int TYPE_20 = 20;


    /**
     * 事件类型  10创建话题评论  20创建商品评论事件
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
                createTopicReply();
                break;
            case TYPE_20:
                createProductReply();
                break;
            default:
        }
    }

    private void createTopicReply()  {
        LogUtil.debugLog(this,"begin comment event");
        if (!(source instanceof TopicCommentEntity)) {
            LogUtil.errorLog(this,"处理创建评论事件出错，事件源不是AppuserEntity");
            return;
        }
        //给父评论增加回复路径，并且把回复加入到父评论的字段中
        TopicCommentEntity topicCommentEntity = (TopicCommentEntity) source;
        TopicCommentMapper topicCommentMapper = (TopicCommentMapper) SpringBeanTools.getBean(TopicCommentMapper.class);
        TopicCommentEntity parentComment = topicCommentMapper.selectByPrimaryKey(topicCommentEntity.getCParentId());

        String replyPath = parentComment.getReplyPath();
        String lastReplyId = "";
        if(!EmptyUtil.isEmpty(replyPath)){
            lastReplyId = replyPath.split("/")[0];

        }
        parentComment.setReplyPath(topicCommentEntity.getId()+"/"+(parentComment.getReplyPath()==null?"":parentComment.getReplyPath()));

        //把topicCommentEntity和childrenComment加入到最新的评论字段中
        List<TopicCommentEntity> topicCommentEntityList = new ArrayList<>();
        topicCommentEntityList.add(topicCommentEntity);

        if(!EmptyUtil.isEmpty(lastReplyId)){
            TopicCommentEntity childrenComment = topicCommentMapper.selectByPrimaryKey(lastReplyId);
            topicCommentEntityList.add(childrenComment);
        }


        parentComment.setReply(JSON.toJSONString(topicCommentEntityList));
        topicCommentMapper.updateByPrimaryKeySelective(parentComment);

    }


    private void createProductReply()  {
        LogUtil.debugLog(this,"begin comment event");
        if (!(source instanceof ProductCommentEntity)) {
            LogUtil.errorLog(this,"处理创建商品评论事件出错，事件源不是 ProductCommentEntity");
            return;
        }
        //给父评论增加回复路径，并且把回复加入到父评论的字段中
        ProductCommentEntity productCommentEntity = (ProductCommentEntity) source;
        ProductCommentMapper productCommentMapper = (ProductCommentMapper) SpringBeanTools.getBean(ProductCommentMapper.class);
        ProductCommentEntity parentComment = productCommentMapper.selectByPrimaryKey(productCommentEntity.getCParentId());

        String replyPath = parentComment.getReplyPath();
        String lastReplyId = "";
        if(!EmptyUtil.isEmpty(replyPath)){
            lastReplyId = replyPath.split("/")[0];

        }
        parentComment.setReplyPath(productCommentEntity.getId()+"/"+(parentComment.getReplyPath()==null?"":parentComment.getReplyPath()));

        //把productCommentEntity和childrenComment加入到最新的评论字段中
        List<ProductCommentEntity> productCommentEntityList = new ArrayList<>();
        productCommentEntityList.add(productCommentEntity);

        if(!EmptyUtil.isEmpty(lastReplyId)){
            ProductCommentEntity childrenComment = productCommentMapper.selectByPrimaryKey(lastReplyId);
            productCommentEntityList.add(childrenComment);
        }


        parentComment.setReply(JSON.toJSONString(productCommentEntityList));
        productCommentMapper.updateByPrimaryKeySelective(parentComment);

    }

}
