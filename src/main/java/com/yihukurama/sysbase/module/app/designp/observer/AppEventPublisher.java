package com.yihukurama.sysbase.module.app.designp.observer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 */
@Component
public class AppEventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.applicationContext=applicationContext;
    }
    @Async("asyncServiceExecutor")
    public void publishEvent(ApplicationEvent event){

        applicationContext.publishEvent(event);
    }
}

