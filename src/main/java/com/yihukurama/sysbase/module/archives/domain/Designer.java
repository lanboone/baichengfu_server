package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.DesignerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Designer extends DesignerEntity {

    @ApiModelProperty(value = "设计师在app上的用户名")
    private String appUserName;
    @ApiModelProperty(value = "设计师在app上的手机号")
    private String appUserPhone;

}
