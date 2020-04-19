package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.controller.app.dto.*;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.app.ITopic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 说明： 系统模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "APP话题模块", tags = "APP话题模块接口")
@RestController
@RequestMapping("/app_topic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppTopicController {


    @Autowired
    ITopic iTopic;


    @ApiOperation(value = "通过评论列表获取回复",notes = "通过评论列表获取回复")
    @RequestMapping(value = "/refresh_comment_list", method = RequestMethod.POST)
    public Result refreshCommentList(@RequestBody Request<CommentChildrenDto> request) throws Exception {


        return iTopic.refreshCommentList(request);
    }

}

