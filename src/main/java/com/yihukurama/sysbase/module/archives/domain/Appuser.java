package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Appuser extends AppuserEntity {


    /**
     * 验证码
     */
    @ApiModelProperty(value="验证码")
    private String checkCode;
}
