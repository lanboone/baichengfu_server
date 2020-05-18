package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.mapper.SampleRoomMapper;
import com.yihukurama.sysbase.mapper.TopicCommentMapper;
import com.yihukurama.sysbase.mapper.TopicMapper;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserNotify;
import com.yihukurama.sysbase.module.archives.domain.PushNotify;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserNotifyService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 说明： 消息推送事件
 * @author yihukurama
 * @date Created in 16:52 2020/4/19
 *       Modified by yihukurama in 16:52 2020/4/19
 */
public class PushEvent extends ApplicationEvent {
    /**
     * 后台推送事件
     */
    public final static int TYPE_10 = 10;
    
    private Integer type;

    public PushEvent(Object source) {
        super(source);
    }

    public PushEvent(Object source, Integer type) {
        super(source);
        this.type = type;
    }


    public void handleEvent(){
        switch (type){
            case TYPE_10:
                handlePushNotify();
                break;
            default:
        }
    }

    public void handlePushNotify() {
        if (!(source instanceof PushNotify)) {
            LogUtil.errorLog(this,"处理推送事件出错，事件源不是 PushNotify");
            return;
        }
        //给app消息创建记录
        AppuserNotifyService appuserNotifyService = (AppuserNotifyService) SpringBeanTools.getBean(AppuserNotifyService.class);
        AppuserEntity appuserEntity = new AppuserEntity();




    }

}
