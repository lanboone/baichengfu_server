package com.yihukurama.sysbase.controller.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("点赞、取消点赞接口-请求参数")
public class ClickGoodDto {

    @ApiModelProperty(value = "评论id",example = "'12345678911'")
    @NotBlank(message = "评论id必填(commentId)")
    String commentId;
    @ApiModelProperty(value = "话题id",example = "'12345678911'")
    @NotBlank(message = "话题id必填(topicId)")
    String topicId;
    @ApiModelProperty(value = "自己的appuserId",example = "'453456'")
    @NotBlank(message = "自己的用户Id必填（appuserId）")
    String appuserId;

}
