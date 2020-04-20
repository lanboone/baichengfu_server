package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.mapper.TopicCommentMapper;
import com.yihukurama.sysbase.mapper.TopicMapper;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.TopicComment;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 说明： 用户事件
 * @author yihukurama
 * @date Created in 16:52 2020/4/19
 *       Modified by yihukurama in 16:52 2020/4/19
 */
public class AppuserEvent extends ApplicationEvent {
    /**
     * 更新头像事件
     */
    public final static int TYPE_10 = 10;
    /**
     * 更新昵称事件
     */
    public final static int TYPE_20 = 20;


    private Integer type;

    public AppuserEvent(Object source) {
        super(source);
    }

    public AppuserEvent(Object source,Integer type) {
        super(source);
        this.type = type;
    }


    public void handleEvent(){
        switch (type){
            case TYPE_10:
                handleUpdateHeadEvent();
                break;
            case TYPE_20:
                handleUpdateNickNameEvent();
                break;
            default:
        }
    }

    public void handleUpdateNickNameEvent() {
        if (!(source instanceof Appuser)) {
            LogUtil.errorLog(this,"处理更新昵称事件出错，事件源不是AppuserEntity");
            return;
        }
        DesignerMapper designerMapper = (DesignerMapper) SpringBeanTools.getBean(DesignerMapper.class);
        SampleRoomMapper sampleRoomMapper = (SampleRoomMapper) SpringBeanTools.getBean(SampleRoomMapper.class);
        TopicMapper topicMapper = (TopicMapper) SpringBeanTools.getBean(TopicMapper.class);
        TopicCommentMapper topicCommentMapper = (TopicCommentMapper) SpringBeanTools.getBean(TopicCommentMapper.class);
        Appuser appuser = (Appuser) source;



        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setCreaterId(appuser.getId());
        List<TopicEntity> topicEntityList = topicMapper.select(topicEntity);
        if(topicEntityList != null){
            for (int i = 0; i < topicEntityList.size(); i++) {
                TopicEntity updateTopicEntity = topicEntityList.get(0);
                updateTopicEntity.setTopicName(appuser.getNickName());
                topicMapper.updateByPrimaryKeySelective(updateTopicEntity);
            }
        }

        TopicCommentEntity topicCommentEntity = new TopicCommentEntity();
        topicCommentEntity.setCreaterId(appuser.getId());
        List<TopicCommentEntity> topicCommentEntityList = topicCommentMapper.select(topicCommentEntity);
        if(topicCommentEntityList != null){
            for (int i = 0; i < topicCommentEntityList.size(); i++) {
                TopicCommentEntity updateTopicCommentEntity = topicCommentEntityList.get(0);
                updateTopicCommentEntity.setCommentName(appuser.getNickName());
                topicCommentMapper.updateByPrimaryKeySelective(updateTopicCommentEntity);
            }
        }


        DesignerEntity designerEntity = new DesignerEntity();
        designerEntity.setUserId(appuser.getId());
        List<DesignerEntity> designerEntityList = designerMapper.select(designerEntity);
        if(!EmptyUtil.isEmpty(designerEntityList)){
            for (int i = 0; i < designerEntityList.size(); i++) {
                DesignerEntity designer = designerEntityList.get(i);
                designer.setNickName(appuser.getNickName());
                designerMapper.updateByPrimaryKeySelective(designer);

                //更新设计师关联的样板间数据
                SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
                sampleRoomEntity.setDesignerId(designer.getId());
                List<SampleRoomEntity> sampleRoomEntityList = sampleRoomMapper.select(sampleRoomEntity);
                if(!EmptyUtil.isEmpty(sampleRoomEntityList)){
                    for (int j = 0; j < sampleRoomEntityList.size(); j++) {

                        SampleRoomEntity sampleRoom = sampleRoomEntityList.get(0);
                        sampleRoom.setDesignerName(appuser.getNickName());
                        sampleRoomMapper.updateByPrimaryKeySelective(sampleRoom);
                    }
                }
            }
        }

    }

    public void handleUpdateHeadEvent() {
        if (!(source instanceof AppuserEntity)) {
            LogUtil.errorLog(this,"处理更新头像事件出错，事件源不是AppuserEntity");
            return;
        }
        DesignerMapper designerMapper = (DesignerMapper) SpringBeanTools.getBean(DesignerMapper.class);
        SampleRoomMapper sampleRoomMapper = (SampleRoomMapper) SpringBeanTools.getBean(SampleRoomMapper.class);
        TopicMapper topicMapper = (TopicMapper) SpringBeanTools.getBean(TopicMapper.class);
        TopicCommentMapper topicCommentMapper = (TopicCommentMapper) SpringBeanTools.getBean(TopicCommentMapper.class);

        Appuser appuser = (Appuser) source;

        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setCreaterId(appuser.getId());
        List<TopicEntity> topicEntityList = topicMapper.select(topicEntity);
        if(topicEntityList != null){
            for (int i = 0; i < topicEntityList.size(); i++) {
                TopicEntity updateTopicEntity = topicEntityList.get(0);
                updateTopicEntity.setTopicHead(appuser.getHeadUrl());
                topicMapper.updateByPrimaryKeySelective(updateTopicEntity);
            }
        }

        TopicCommentEntity topicCommentEntity = new TopicCommentEntity();
        topicCommentEntity.setCreaterId(appuser.getId());
        List<TopicCommentEntity> topicCommentEntityList = topicCommentMapper.select(topicCommentEntity);
        if(topicCommentEntityList != null){
            for (int i = 0; i < topicCommentEntityList.size(); i++) {
                TopicCommentEntity updateTopicCommentEntity = topicCommentEntityList.get(0);
                updateTopicCommentEntity.setCommentHead(appuser.getHeadUrl());
                topicCommentMapper.updateByPrimaryKeySelective(updateTopicCommentEntity);
            }
        }



        DesignerEntity designerEntity = new DesignerEntity();
        designerEntity.setUserId(appuser.getId());
        List<DesignerEntity> designerEntityList = designerMapper.select(designerEntity);
        if(!EmptyUtil.isEmpty(designerEntityList)){
            for (DesignerEntity designer:designerEntityList
            ) {
                designer.setHeadUrl(appuser.getHeadUrl());
                designerMapper.updateByPrimaryKeySelective(designer);

                //更新设计师关联的样板间数据
                SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
                sampleRoomEntity.setDesignerId(designer.getId());
                List<SampleRoomEntity> sampleRoomEntityList = sampleRoomMapper.select(sampleRoomEntity);
                if(!EmptyUtil.isEmpty(sampleRoomEntityList)){
                    for (SampleRoomEntity sampleRoom:sampleRoomEntityList
                    ) {
                        sampleRoom.setDesignerHead(appuser.getHeadUrl());
                        sampleRoomMapper.updateByPrimaryKeySelective(sampleRoom);
                    }
                }
            }
        }

    }
}
