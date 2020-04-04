package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.controller.app.dto.FocusDesignerDto;
import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.model.AppuserDesignerEntity;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.sysbase.module.app.IPerson;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserDesignerService;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserService;
import com.yihukurama.sysbase.module.archives.service.domainservice.DesignerService;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明： app用户个人的接口
 * @author yihukurama
 * @date Created in 17:06 2020/4/4
 *       Modified by yihukurama in 17:06 2020/4/4
 */
@Service
public class PersonService implements IPerson {

    @Autowired
    AppuserDesignerService appuserDesignerService;
    @Autowired
    AppuserService appuserService;
    @Autowired
    AppuserMapper appuserMapper;
    @Autowired
    DesignerService designerService;
    @Autowired
    DesignerMapper designerMapper;
    @Override
    public Result focusDesigner(Request<FocusDesignerDto> request) throws TipsException {
        FocusDesignerDto focusDesignerDto = request.getData();
        AppuserDesignerEntity appuserDesignerEntity = new AppuserDesignerEntity();
        appuserDesignerEntity.setAppuserId(focusDesignerDto.getAppuserId());
        appuserDesignerEntity.setDesignerId(focusDesignerDto.getDesignerId());


        List<AppuserDesignerEntity> appuserDesignerEntities =  appuserDesignerService.list(appuserDesignerEntity);
        if(!EmptyUtil.isEmpty(appuserDesignerEntities)){
            return Result.failed(appuserDesignerEntities.get(0),"用户已关注",-1);
        }
        //获取设计师身份数据
        String designerId = focusDesignerDto.getDesignerId();
        DesignerEntity designerEntity = designerMapper.selectByPrimaryKey(designerId);

        appuserDesignerEntity.setGloryValue(designerEntity.getGloryValue());
        appuserDesignerEntity.setHeadUrl(designerEntity.getHeadUrl());
        appuserDesignerEntity.setNickName(designerEntity.getNickName());
        appuserDesignerEntity.setStyle(designerEntity.getStyle());

        appuserDesignerEntity = appuserDesignerService.create(appuserDesignerEntity);

        if(appuserDesignerEntity == null){
            return Result.failed(null,"关注失败",-1);
        }

        return Result.successed(appuserDesignerEntity,"新增关注成功");

    }

    @Override
    public Result unFocusDesigner(Request<FocusDesignerDto> request) throws TipsException {
        FocusDesignerDto focusDesignerDto = request.getData();
        AppuserDesignerEntity appuserDesignerEntity = new AppuserDesignerEntity();
        appuserDesignerEntity.setAppuserId(focusDesignerDto.getAppuserId());
        appuserDesignerEntity.setDesignerId(focusDesignerDto.getDesignerId());


        List<AppuserDesignerEntity> appuserDesignerEntities =  appuserDesignerService.list(appuserDesignerEntity);
        if(EmptyUtil.isEmpty(appuserDesignerEntities)){
            return Result.failed(appuserDesignerEntities.get(0),"已取消关注",-1);
        }

        appuserDesignerService.remove(appuserDesignerEntities.get(0));

        return Result.successed(appuserDesignerEntity,"取消关注成功");

    }
}
