package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.mapper.AppuserTopicMapper;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.mapper.TopicMapper;
import com.yihukurama.sysbase.model.AppuserTopicEntity;
import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import com.yihukurama.sysbase.model.TopicEntity;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserTopicService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 说明： 话题事件
 * @author yihukurama
 * @date Created in 16:50 2020/4/19
 *       Modified by yihukurama in 16:50 2020/4/19
 */
public class TopicEvent extends ApplicationEvent {
    /**
     * 收藏话题事件
     */
    public final static int TYPE_10 = 10;
    /**
     * 取消收藏话题事件
     */
    public final static int TYPE_20 = 20;
    /**
     * 事件类型 10收藏话题   20取消收藏话题
     */
    private Integer type;

    public TopicEvent(Object source) {
        super(source);
    }


    public TopicEvent(Object source,Integer type) {
        super(source);
        this.type = type;
    }


    public void handleEvent(){
        switch (type){
            case TYPE_10:
                storeTopic();
                break;
            case TYPE_20:
                unStoreTopic();
                break;
            default:
        }
    }
    /**
     * 说明： 收藏话题事件
     * @author yihukurama
     * @date Created in 16:52 2020/4/19
     *       Modified by yihukurama in 16:52 2020/4/19
     */
    public void storeTopic(){
        if (!(source instanceof AppuserTopicEntity)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 AppuserTopicEntity");
            return;
        }

        //话题收藏数+1
        AppuserTopicEntity appuserTopicEntity = (AppuserTopicEntity) source;
        TopicMapper topicMapper = (TopicMapper) SpringBeanTools.getBean(AppuserTopicService.class);
        TopicEntity topicEntity = topicMapper.selectByPrimaryKey(appuserTopicEntity.getTopicId());
        TopicEntity updateTopicEntity = new TopicEntity();
        updateTopicEntity.setId(topicEntity.getId());
        updateTopicEntity.setTFavoriteNumber(NumberUtil.NullPlus(topicEntity.getTFavoriteNumber(),1));
        topicMapper.updateByPrimaryKeySelective(updateTopicEntity);

    }

    /**
     * 说明： 取消话题收藏事件
     * @author yihukurama
     * @date Created in 16:52 2020/4/19
     *       Modified by yihukurama in 16:52 2020/4/19
     */
    public void unStoreTopic(){

        if (!(source instanceof AppuserTopicEntity)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 AppuserTopicEntity");
            return;
        }

        //话题收藏数-1
        AppuserTopicEntity appuserTopicEntity = (AppuserTopicEntity) source;
        TopicMapper topicMapper = (TopicMapper) SpringBeanTools.getBean(AppuserTopicService.class);
        TopicEntity topicEntity = topicMapper.selectByPrimaryKey(appuserTopicEntity.getTopicId());
        TopicEntity updateTopicEntity = new TopicEntity();
        updateTopicEntity.setId(topicEntity.getId());
        updateTopicEntity.setTFavoriteNumber(topicEntity.getTFavoriteNumber()-1);
        topicMapper.updateByPrimaryKeySelective(updateTopicEntity);

    }
}
