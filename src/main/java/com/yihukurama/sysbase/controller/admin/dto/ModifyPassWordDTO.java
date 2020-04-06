package com.yihukurama.sysbase.controller.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: liyuan
 * @date: 2020/4/6 12:57
 * @description: 修改密码接口-带检验
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("修改密码接口-带检验")
public class ModifyPassWordDTO {
    @ApiModelProperty(value = "id", example = "1")
    @NotBlank(message = "id不能为空")
    String id;
    @ApiModelProperty(value = "旧登录密码", example = "123456")
    @NotBlank(message = "旧登录密码不能为空")
    String oldPassword;
    @ApiModelProperty(value = "新登录密码", example = "1234567")
    @NotBlank(message = "新登录密码不能为空")
    String newPassword;
}
