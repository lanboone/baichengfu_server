package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.model.AppuserNotifyEntity;
import com.yihukurama.sysbase.model.PushNotifyEntity;

public class AppuserNotify extends AppuserNotifyEntity {

    /**
     * 通过用户数据和推送数据构建用户推送关联数据
     * @param appuserEntity
     * @param pushNotifyEntity
     * @return
     */
    public AppuserNotify buildAppuserNotify(AppuserEntity appuserEntity, PushNotifyEntity pushNotifyEntity){
        if(appuserEntity == null || pushNotifyEntity == null){
            return null;
        }

        AppuserNotify appuserNotify = new AppuserNotify();
        appuserNotify.setReceiverId(appuserEntity.getId());
        appuserNotify.setContent(pushNotifyEntity.getContent());
        appuserNotify.setSenderType(pushNotifyEntity.getSenderType());
        appuserNotify.setSenderId(pushNotifyEntity.getCreaterId());
        return appuserNotify;
    }
}
