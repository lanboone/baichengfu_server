package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.module.app.designp.observer.AppEventPublisher;
import com.yihukurama.sysbase.module.app.designp.observer.event.AppuserEvent;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明： Appuser的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class AppuserService extends CrudService<AppuserEntity>{


    @Autowired
    DesignerMapper designerMapper;

    @Autowired
    SampleRoomMapper sampleRoomMapper;

    @Autowired
    AppEventPublisher appEventPublisher;


    @Override
    public AppuserEntity update(AppuserEntity appuserEntity) throws TipsException {
        if(appuserEntity instanceof Appuser){
            AppuserEntity orgAppuser = this.load(appuserEntity);
            if(EmptyUtil.isEmpty(orgAppuser.getNickName())){
                orgAppuser.setNickName("");
            }
            if(!orgAppuser.getNickName().equals(appuserEntity.getNickName())){
                //更新昵称
                appEventPublisher.publishEvent(new AppuserEvent(appuserEntity,AppuserEvent.TYPE_20));
            }
            if(!orgAppuser.getHeadUrl().equals(appuserEntity.getHeadUrl())){
                //更新头像
                appEventPublisher.publishEvent(new AppuserEvent(appuserEntity,AppuserEvent.TYPE_10));
            }
        }

        return super.update(appuserEntity);
    }
}
