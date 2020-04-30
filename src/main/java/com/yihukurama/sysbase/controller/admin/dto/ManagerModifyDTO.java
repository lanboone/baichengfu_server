package com.yihukurama.sysbase.controller.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: liyuan
 * @date: 2020/4/6 12:25
 * @description: 管理员修改用户名和手机号的接口
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员修改用户名和手机号的接口")
public class ManagerModifyDTO {
    @ApiModelProperty(value = "id", example = "1")
    @NotBlank(message = "id不能为空")
    String id;
    @ApiModelProperty(value = "用户名", example = "admin1")
    @NotBlank(message = "用户名不能为空")
    String managerName;
    @ApiModelProperty(value = "手机号", example = "13531667979")
    @NotBlank(message = "手机号不能为空")
    String sysPhone;
}
