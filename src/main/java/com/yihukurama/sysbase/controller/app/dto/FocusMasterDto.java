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
@ApiModel("关注装修师，取关装修师接口-请求参数")
public class FocusMasterDto {

    @ApiModelProperty(value = "装修师id",example = "'12345678911'")
    @NotBlank(message = "装修师id必填(masterId)")
    String masterId;
    @ApiModelProperty(value = "自己的appuserId",example = "'453456'")
    @NotBlank(message = "自己的用户Id必填（appuserId）")
    String appuserId;

}
