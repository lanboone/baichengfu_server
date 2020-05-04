package com.yihukurama.sysbase.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("快递100查询接口")
public class EmsSearchDto {

    @ApiModelProperty(value = "快递公司编号",example = "'12345678911'")
    @NotBlank(message = "快递公司编号必填")
    String com;
    @ApiModelProperty(value = "快递单号",example = "'12345678911'")
    @NotBlank(message = "快递单号必填")
    String num;
}
