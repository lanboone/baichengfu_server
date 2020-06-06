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
@ApiModel("删除操作记录-带检验")
public class DeleteOperateDTO {
    @ApiModelProperty(value = "月数", example = "3")
    @NotBlank(message = "传入地月数必须是3或6")
    Integer month;
}
