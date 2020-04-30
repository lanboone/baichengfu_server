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
@ApiModel("Token登录接口-请求参数")
public class TokenLoginDto {

    @ApiModelProperty(value = "app用户id",example = "34bb8f006db94aafb9395b73eb3e7241")
    @NotBlank(message = "【appUserId】app用户id必填")
    String appUserId;
    @ApiModelProperty(value = "登录token",example = "34bb8f006db94aafb9395b73eb3e7241")
    @NotBlank(message = "【token】登录方式必填")
    String token;
}
