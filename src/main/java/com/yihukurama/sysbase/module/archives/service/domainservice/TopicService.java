package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.TopicEntity;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Service;

/**
 * 说明： Topic的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class TopicService extends CrudService<TopicEntity>{

    @Override
    public TopicEntity create(TopicEntity topicEntity) throws TipsException {
        if(EmptyUtil.isEmpty(topicEntity.getTopicImage())
        ||EmptyUtil.isEmpty(topicEntity.getTopicTitle())
        ||EmptyUtil.isEmpty(topicEntity.getTopicContent())){
            throw new TipsException("话题标题、封面图、内容不可为空");
        }
        return super.create(topicEntity);
    }
}
