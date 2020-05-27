package com.yihukurama.sysbase.module.app.designp.observer;

import com.yihukurama.sysbase.module.app.designp.observer.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
@Component
public class AppEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
            // TODO Auto-generated method stub
        if(event instanceof AppuserEvent){
            AppuserEvent myEvent = (AppuserEvent) event;
            myEvent.handleEvent();
        }
        if(event instanceof TopicEvent){
            TopicEvent myEvent = (TopicEvent) event;
            myEvent.handleEvent();
        }
        if(event instanceof CommentEvent){
            CommentEvent myEvent = (CommentEvent) event;
            myEvent.handleEvent();
        }
        if(event instanceof PushEvent){
            PushEvent myEvent = (PushEvent) event;
            myEvent.handleEvent();
        }
        if(event instanceof ProductEvent){
            ProductEvent myEvent = (ProductEvent) event;
            myEvent.handleEvent();
        }
    }
}
