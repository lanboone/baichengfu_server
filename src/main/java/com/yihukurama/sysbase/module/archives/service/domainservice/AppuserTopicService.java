package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.AppuserTopic;
import com.yihukurama.sysbase.module.archives.domain.AppuserSample;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AppuserTopicService extends CrudService<AppuserTopicEntity> {

    @Autowired
    TopicService topicService;

    @Override
    public Result list(AppuserTopicEntity appuserTopicEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(appuserTopicEntity, page, limit);
        if(appuserTopicEntity instanceof AppuserTopic){
            AppuserTopic appuserTopic  = (AppuserTopic) appuserTopicEntity;
            if(appuserTopic.getSearchType() == AppuserTopic.SEARCH_TYPE_10){
                return result;
            }
            List<AppuserTopicEntity> appuserTopicEntityList = (List<AppuserTopicEntity>) result.getData();
            List<AppuserTopic> appuserPTopicList = TransferUtils.transferEntityList2DomainList(appuserTopicEntityList,AppuserTopic.class);
            if(!CollectionUtils.isEmpty(appuserTopicEntityList)){
                for (int i = 0; i < appuserPTopicList.size(); i++) {
                    String proId = appuserPTopicList.get(i).getTopicId();
                    TopicEntity topicEntity = new TopicEntity();
                    topicEntity.setId(proId);
                    topicEntity = topicService.load(topicEntity);
                    appuserPTopicList.get(i).setTopicEntity(topicEntity);
                }
            }
            result.setData(appuserPTopicList);
        }
        return  result;
    }
}
