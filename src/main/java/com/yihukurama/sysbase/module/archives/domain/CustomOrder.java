package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.CustomOrderEntity;
import com.yihukurama.sysbase.model.CustomStepEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class CustomOrder extends CustomOrderEntity {

    @ApiModelProperty(value = "定制步骤")
    List<CustomStepEntity> customStepEntities;
}
