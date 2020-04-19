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
@ApiModel("收藏、取消收藏话题接口-请求参数")
public class StoreTopicDto {

    @ApiModelProperty(value = "话题id",example = "'12345678911'")
    @NotBlank(message = "话题id必填(topicId)")
    String topicId;
    @ApiModelProperty(value = "自己的appuserId",example = "'453456'")
    @NotBlank(message = "自己的用户Id必填（appuserId）")
    String appuserId;

}
