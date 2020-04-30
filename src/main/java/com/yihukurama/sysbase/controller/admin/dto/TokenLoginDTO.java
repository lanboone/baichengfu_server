package com.yihukurama.sysbase.controller.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员Token登录接口-请求参数")
public class TokenLoginDTO {

    @ApiModelProperty(value = "管理员id",example = "34bb8f006db94aafb9395b73eb3e7241")
    @NotBlank(message = "【managerId】管理员id必填")
    String managerId;
    @ApiModelProperty(value = "登录token",example = "34bb8f006db94aafb9395b73eb3e7241")
    @NotBlank(message = "【token】登录方式必填")
    String token;
}
