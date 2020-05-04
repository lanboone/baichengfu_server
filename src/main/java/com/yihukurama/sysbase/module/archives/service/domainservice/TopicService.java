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
