package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.controller.app.dto.ClickGoodDto;
import com.yihukurama.sysbase.controller.app.dto.FocusDesignerDto;
import com.yihukurama.sysbase.controller.app.dto.StoreSampleRoomDto;
import com.yihukurama.sysbase.controller.app.dto.StoreTopicDto;
import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.app.IPerson;
import com.yihukurama.sysbase.module.app.designp.observer.AppEventPublisher;
import com.yihukurama.sysbase.module.app.designp.observer.event.TopicEvent;
import com.yihukurama.sysbase.module.archives.service.domainservice.*;
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
    AppuserCommentService appuserCommentService;
    @Autowired
    AppuserTopicService appuserTopicService;
    @Autowired
    AppEventPublisher appEventPublisher;

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
    @Autowired
    AppuserSampleService appuserSampleService;
    @Autowired
    SampleRoomService sampleRoomService;

    @Override
    public Result storeSampleRoom(Request<StoreSampleRoomDto> request) throws TipsException {
        AppuserSampleEntity appuserSampleEntity = new AppuserSampleEntity();
        appuserSampleEntity.setAppuserId(request.getData().getAppuserId());
        appuserSampleEntity.setSampleId(request.getData().getSampleId());

        List<AppuserSampleEntity> appuserSampleEntityList = appuserSampleService.list(appuserSampleEntity);
        if(!EmptyUtil.isEmpty(appuserSampleEntityList)){
            return Result.failed(null,"您已收藏",-1);
        }
        appuserSampleEntity = appuserSampleService.create(appuserSampleEntity);
        if(appuserSampleEntity == null){
            return Result.failed(null,"收藏失败",-20);

        }
        //增加收藏数和权重数
        SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
        sampleRoomEntity.setId(request.getData().getSampleId());
        sampleRoomEntity = sampleRoomService.load(sampleRoomEntity);
        if(sampleRoomEntity == null){
            return Result.failed("无此样板间，id为:"+request.getData().getSampleId());
        }

        sampleRoomEntity.setFocusCount(NumberUtil.NullPlus(sampleRoomEntity.getFocusCount(),1));
        sampleRoomEntity.setOrderCount(NumberUtil.NullPlus(sampleRoomEntity.getOrderCount(),1));
        sampleRoomService.update(sampleRoomEntity);
        return Result.successed(appuserSampleEntity,"收藏成功");
    }

    @Override
    public Result unStoreSampleRoom(Request<StoreSampleRoomDto> request) throws TipsException {
        AppuserSampleEntity appuserSampleEntity = new AppuserSampleEntity();
        appuserSampleEntity.setAppuserId(request.getData().getAppuserId());
        appuserSampleEntity.setSampleId(request.getData().getSampleId());

        List<AppuserSampleEntity> appuserSampleEntityList = appuserSampleService.list(appuserSampleEntity);
        if(EmptyUtil.isEmpty(appuserSampleEntityList)){
            return Result.failed(null,"您已取消收藏",-1);
        }
        int removeCount = appuserSampleService.remove(appuserSampleEntityList.get(0));
        if(removeCount == 1){
            //减少收藏数和权重数
            SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
            sampleRoomEntity.setId(request.getData().getSampleId());
            sampleRoomEntity = sampleRoomService.load(sampleRoomEntity);
            if(sampleRoomEntity.getFocusCount() !=  null || sampleRoomEntity.getFocusCount() > 0){
                sampleRoomEntity.setFocusCount(sampleRoomEntity.getFocusCount()-1);
            }else{
                sampleRoomEntity.setFocusCount(0);
            }
            if(sampleRoomEntity.getFocusCount() !=  null || sampleRoomEntity.getFocusCount() > 0){
                sampleRoomEntity.setOrderCount(sampleRoomEntity.getOrderCount()-1);
            }else{
                sampleRoomEntity.setOrderCount(0);
            }
            sampleRoomService.update(sampleRoomEntity);
            return Result.successed(appuserSampleEntity,"取消收藏成功");
        }
        return Result.failed(null,"取消收藏失败",-20);
    }

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
        if(designerEntity == null){
            return Result.failed("无此设计师,设计师id为:"+designerId);
        }
        appuserDesignerEntity.setGloryValue(designerEntity.getGloryValue());
        appuserDesignerEntity.setHeadUrl(designerEntity.getHeadUrl());
        appuserDesignerEntity.setNickName(designerEntity.getNickName());
        appuserDesignerEntity.setStyle(designerEntity.getStyle());

        appuserDesignerEntity = appuserDesignerService.create(appuserDesignerEntity);

        if(appuserDesignerEntity == null){
            return Result.failed(null,"关注失败",-1);
        }

        //更新设计师关注数
        designerEntity.setLikecount(NumberUtil.NullPlus(designerEntity.getLikecount(),1));
        designerService.update(designerEntity);

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

    @Override
    public Result readSampleRoom(Request<StoreSampleRoomDto> request) throws TipsException {
        //增加浏览数和权重数
        SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
        sampleRoomEntity.setId(request.getData().getSampleId());
        sampleRoomEntity = sampleRoomService.load(sampleRoomEntity);
        if(sampleRoomEntity == null){
            return Result.failed("样板间不存在,id为："+request.getData().getSampleId());
        }
        sampleRoomEntity.setSFavoriteNumber(NumberUtil.NullPlus(sampleRoomEntity.getSFavoriteNumber(),1));
        sampleRoomEntity.setOrderCount(NumberUtil.NullPlus(sampleRoomEntity.getOrderCount(),1));
        sampleRoomService.update(sampleRoomEntity);
        return Result.successed("添加浏览数成功");
    }

    @Autowired
    TopicService topicService;
    @Override
    public Result readTopic(Request<StoreTopicDto> request) throws TipsException {
        //增加浏览数和权重数
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setId(request.getData().getTopicId());
        topicEntity = topicService.load(topicEntity);
        topicEntity.setTViewingCount(NumberUtil.NullPlus(topicEntity.getTViewingCount(),1));
        topicService.update(topicEntity);
        return Result.successed("添加话题浏览数成功");
    }

    @Override
    public Result storeTopic(Request<StoreTopicDto> request) throws TipsException {
        AppuserTopicEntity appuserTopicEntity = new AppuserTopicEntity();
        appuserTopicEntity.setAppuserId(request.getData().getAppuserId());
        appuserTopicEntity.setTopicId(request.getData().getTopicId());

        List<AppuserTopicEntity> appuserTopicEntityList = appuserTopicService.list(appuserTopicEntity);
        if(!EmptyUtil.isEmpty(appuserTopicEntityList)){
            return Result.failed(null,"您已收藏",-1);
        }
        appuserTopicEntity = appuserTopicService.create(appuserTopicEntity);
        if(appuserTopicEntity == null){
            return Result.failed(null,"收藏失败",-20);

        }
        appEventPublisher.publishEvent(new TopicEvent(appuserTopicEntity,TopicEvent.TYPE_10));
        return Result.successed(appuserTopicEntity,"收藏成功");
    }

    @Override
    public Result unStoreTopic(Request<StoreTopicDto> request) throws TipsException {
        AppuserTopicEntity appuserTopicEntity = new AppuserTopicEntity();
        appuserTopicEntity.setAppuserId(request.getData().getAppuserId());
        appuserTopicEntity.setTopicId(request.getData().getTopicId());

        List<AppuserTopicEntity> appuserTopicEntityList = appuserTopicService.list(appuserTopicEntity);
        if(EmptyUtil.isEmpty(appuserTopicEntityList)){
            return Result.failed(null,"您已取消收藏",-1);
        }
        int removeCount = appuserTopicService.remove(appuserTopicEntityList.get(0));
        if(removeCount == 1){
            //减少收藏数
            appEventPublisher.publishEvent(new TopicEvent(appuserTopicEntity,TopicEvent.TYPE_20));
            return Result.successed(appuserTopicEntity,"取消收藏成功");
        }
        return Result.failed(null,"取消收藏失败",-20);
    }

    @Override
    public Result clickGood(Request<ClickGoodDto> request) throws TipsException {
        AppuserCommentEntity appuserCommentEntity = new AppuserCommentEntity();
        appuserCommentEntity.setAppuserId(request.getData().getAppuserId());
        appuserCommentEntity.setTopicId(request.getData().getTopicId());
        appuserCommentEntity.setCommentId(request.getData().getCommentId());
        List<AppuserCommentEntity> appuserCommentEntityList = appuserCommentService.list(appuserCommentEntity);
        if(!EmptyUtil.isEmpty(appuserCommentEntityList)){
            return Result.failed(null,"您已点赞",-1);
        }
        appuserCommentEntity = appuserCommentService.create(appuserCommentEntity);
        if(appuserCommentEntity == null){
            return Result.failed(null,"点赞失败",-20);

        }
        return Result.successed(appuserCommentEntity,"点赞成功");
    }

    @Override
    public Result unClickGood(Request<ClickGoodDto> request) throws TipsException {
        AppuserCommentEntity appuserCommentEntity = new AppuserCommentEntity();
        appuserCommentEntity.setAppuserId(request.getData().getAppuserId());
        appuserCommentEntity.setTopicId(request.getData().getTopicId());
        appuserCommentEntity.setCommentId(request.getData().getCommentId());
        List<AppuserCommentEntity> appuserCommentEntityList = appuserCommentService.list(appuserCommentEntity);
        if(EmptyUtil.isEmpty(appuserCommentEntityList)){
            return Result.failed(null,"您已取消点赞",-1);
        }
        int removeCount = appuserCommentService.remove(appuserCommentEntityList.get(0));
        if(removeCount == 1){
            return Result.successed(appuserCommentEntity,"取消点赞成功");
        }
        return Result.failed(null,"取消点赞失败",-20);
    }
}
