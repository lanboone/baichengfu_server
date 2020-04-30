package com.yihukurama.sysbase.controller.app.dto;

import com.yihukurama.sysbase.module.archives.domain.TopicComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 说明： 查询评论回复
 *
 * @author yihukurama
 * @date Created in 17:38 2020/4/19
 * Modified by yihukurama in 17:38 2020/4/19
 */
@Data
public class CommentChildrenDto {

    @ApiModelProperty(value = "后端获取到的评论列表")
    @NotBlank(message = "请求参数评论列表不可为空")
    List<TopicComment> topicCommentList;
}
