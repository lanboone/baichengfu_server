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
@ApiModel("忘记密码接口-请求参数")
public class ForgetPwdDto {

    @ApiModelProperty(value = "手机号码",example = "'12345678911'")
    @NotBlank(message = "【phone】手机号必填")
    String phone;
    @ApiModelProperty(value = "验证码",example = "'453456'")
    @NotBlank(message = "【checkCode】验证码必填")
    String checkCode;
    @ApiModelProperty(value = "新密码,建议前端加密",example = "34bb8f006db94aafb9395b73eb3e7241")
    @NotBlank(message = "【password】新密码必填")
    String password;


}
