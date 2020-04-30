package com.yihukurama.sysbase.controller.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: liyuan
 * @date: 2020/4/2 17:06
 * @description: 管理员登录接口
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员登录接口-请求参数")
public class LoginDTO {
    @ApiModelProperty(value = "用户名", example = "admin")
    @NotBlank(message = "用户名不能为空")
    String managerName;
    @ApiModelProperty(value = "登录密码", example = "123456")
    @NotBlank(message = "用户密码不能为空")
    String password;
}
