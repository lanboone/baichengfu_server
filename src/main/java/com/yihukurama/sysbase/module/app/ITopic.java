package com.yihukurama.sysbase.module.app;

import com.yihukurama.sysbase.controller.app.dto.CommentChildrenDto;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;

/**
 * 说明： 话题模块接口
 * @author yihukurama
 * @date Created in 17:53 2020/4/19
 *       Modified by yihukurama in 17:53 2020/4/19
 */
public interface ITopic {

    /**
     * 说明： 根据传入的评论列表，加上回复列表返回
     * @author yihukurama
     * @date Created in 17:53 2020/4/19
     *       Modified by yihukurama in 17:53 2020/4/19
     */
    Result refreshCommentList(Request<CommentChildrenDto> request) throws TipsException;
}
