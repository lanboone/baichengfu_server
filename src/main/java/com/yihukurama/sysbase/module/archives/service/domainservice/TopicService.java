package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.ManagerMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.model.ManagerEntity;
import com.yihukurama.sysbase.model.TopicEntity;
import com.yihukurama.sysbase.module.archives.domain.Topic;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import net.bytebuddy.pool.TypePool;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明： Topic的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class TopicService extends CrudService<TopicEntity>{

    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    AppuserMapper appuserMapper;
    @Override
    public TopicEntity create(TopicEntity topicEntity) throws TipsException {
        if(EmptyUtil.isEmpty(topicEntity.getTopicImage())
        ||EmptyUtil.isEmpty(topicEntity.getTopicTitle())
        ||EmptyUtil.isEmpty(topicEntity.getTopicContent())){
            throw new TipsException("话题标题、封面图、内容不可为空");
        }
        return super.create(topicEntity);
    }

    @Override
    public Result list(TopicEntity designerEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(designerEntity, page, limit);
        List<TopicEntity> topicEntitiesList = (List<TopicEntity>) result.getData();
        List<Topic> topics = new ArrayList<>();
        if (!CollectionUtils.isEmpty(topicEntitiesList)) {
            topicEntitiesList.forEach(topicEntityFromDB -> {
                Topic topic = new Topic();
                BeanUtils.copyProperties(topicEntityFromDB,topic);
                // 创建者类型（10管理员，20App用户）
                if ("20".equals(topicEntityFromDB.getCreatorType())){
                    ManagerEntity managerEntity = new ManagerEntity();
                    managerEntity.setId(topicEntityFromDB.getCreaterId());
                    ManagerEntity managerEntityFromDB = managerMapper.selectOne(managerEntity);
                    if (managerEntityFromDB != null){
                        topic.setPublisherName(managerEntityFromDB.getSysName());
                    }
                }else if ("10".equals(topicEntityFromDB.getCreatorType())){
                    AppuserEntity appuserEntity = new AppuserEntity();
                    appuserEntity.setId(topicEntityFromDB.getCreaterId());
                    AppuserEntity appuserEntityFromDB = appuserMapper.selectOne(appuserEntity);
                    if (appuserEntityFromDB != null){
                        topic.setPublisherName(appuserEntityFromDB.getUserName());
                    }
                }
                topics.add(topic);
            });
            result.setData(topics);
            return result;
        } else {
            return result;
        }
    }
}
