package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.controller.app.dto.*;
import com.yihukurama.sysbase.mapper.AppuserSampleMapper;
import com.yihukurama.sysbase.model.AppuserDesignerEntity;
import com.yihukurama.sysbase.model.AppuserSampleEntity;
import com.yihukurama.sysbase.module.app.IPerson;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserDesigner;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 说明： 个人模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "APP个人模块", tags = "APP个人模块")
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {

    @Autowired
    IPerson person;

    @ApiOperation(value = "获取个人中心各订单数量",notes = "获取个人中心各订单数量,data传入用户id")
    @RequestMapping(value = "/person_count", method = RequestMethod.POST)
    public Result personCount(@RequestBody Request<String> request) throws TipsException {
        return person.personCount(request);
    }

    @ApiOperation(value = "收藏商品",notes = "收藏商品，传入商品id和自己的appuserId")
    @RequestMapping(value = "/store_product", method = RequestMethod.POST)
    public Result storeProduct(@RequestBody Request<StoreProductDto> request) throws Exception {


        return person.storeProduct(request);
    }

    @ApiOperation(value = "取消收藏商品",notes = "取消收藏商品，传入商品id和自己的appuserId")
    @RequestMapping(value = "/un_store_product", method = RequestMethod.POST)
    public Result unStoreProduct(@RequestBody Request<StoreProductDto> request) throws Exception {


        return person.unStoreProduct(request);
    }


    @ApiOperation(value = "关注设计师",notes = "关注设计师，传入设计师的designerId和自己的appuserId")
    @RequestMapping(value = "/focus_designer", method = RequestMethod.POST)
    public Result focusDesigner(@RequestBody Request<FocusDesignerDto> request) throws Exception {



        return person.focusDesigner(request);
    }

    @ApiOperation(value = "取消关注设计师",notes = "关注设计师，传入设计师的designerId和自己的appuserId")
    @RequestMapping(value = "/un_focus_designer", method = RequestMethod.POST)
    public Result unFocusDesigner(@RequestBody Request<FocusDesignerDto> request) throws Exception {



        return person.unFocusDesigner(request);
    }


    @ApiOperation(value = "取消收藏样板间",notes = "取消收藏，样板间Id和自己的appuserId")
    @RequestMapping(value = "/un_store_sample_room", method = RequestMethod.POST)
    public Result unStoreSampleRoom(@RequestBody Request<StoreSampleRoomDto> request) throws Exception {




        return person.unStoreSampleRoom(request);
    }

    @ApiOperation(value = "收藏样板间",notes = "收藏样板间，传入样板间id和自己的appuserId")
    @RequestMapping(value = "/store_sample_room", method = RequestMethod.POST)
    public Result storeSampleRoom(@RequestBody Request<StoreSampleRoomDto> request) throws Exception {


        return person.storeSampleRoom(request);
    }

    @ApiOperation(value = "浏览样板间",notes = "浏览样板间，传入样板间id和自己的appuserId")
    @RequestMapping(value = "/read_sample_room", method = RequestMethod.POST)
    public Result readSampleRoom(@RequestBody Request<StoreSampleRoomDto> request) throws Exception {


        return person.readSampleRoom(request);
    }


    @ApiOperation(value = "浏览话题",notes = "浏览话题，传入话题id和自己的appuserId")
    @RequestMapping(value = "/read_topic", method = RequestMethod.POST)
    public Result readTopic(@RequestBody Request<StoreTopicDto> request) throws Exception {


        return person.readTopic(request);
    }

    @ApiOperation(value = "收藏话题",notes = "收藏话题，传入话题id和自己的appuserId")
    @RequestMapping(value = "/store_topic", method = RequestMethod.POST)
    public Result storeTopic(@RequestBody Request<StoreTopicDto> request) throws Exception {


        return person.storeTopic(request);
    }

    @ApiOperation(value = "取消收藏话题",notes = "取消收藏话题，传入话题id和自己的appuserId")
    @RequestMapping(value = "/un_store_topic", method = RequestMethod.POST)
    public Result unStoreTopic(@RequestBody Request<StoreTopicDto> request) throws Exception {


        return person.unStoreTopic(request);
    }

    @ApiOperation(value ="点赞评论",notes = "点赞评论，传入话题id，评论id和自己的appuserId")
    @RequestMapping(value = "/click_good", method = RequestMethod.POST)
    public Result clickGood(@RequestBody Request<ClickGoodDto> request) throws Exception {


        return person.clickGood(request);
    }

    @ApiOperation(value = "取消点赞",notes = "取消点赞，传入话题id和自己的appuserId")
    @RequestMapping(value = "/un_click_good", method = RequestMethod.POST)
    public Result unClickGood(@RequestBody Request<ClickGoodDto> request) throws Exception {


        return person.unClickGood(request);
    }
}

