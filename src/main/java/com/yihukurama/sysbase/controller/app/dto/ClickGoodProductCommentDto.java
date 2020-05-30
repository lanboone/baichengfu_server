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
@ApiModel("点赞、取消点赞商品评论接口-请求参数")
public class ClickGoodProductCommentDto {

    @ApiModelProperty(value = "评论id",example = "'12345678911'")
    @NotBlank(message = "评论id必填(commentId)")
    String commentId;
    @ApiModelProperty(value = "商品id",example = "'12345678911'")
    @NotBlank(message = "商品id必填(topicId)")
    String productId;
    @ApiModelProperty(value = "自己的appuserId",example = "'453456'")
    @NotBlank(message = "自己的用户Id必填（appuserId）")
    String appuserId;

}
