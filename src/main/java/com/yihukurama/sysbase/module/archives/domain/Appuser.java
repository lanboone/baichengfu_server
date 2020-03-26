package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserEntity;
import lombok.Data;

@Data
public class Appuser extends AppuserEntity {


    /**
     * 注册时要传入的验证码
     */
    private String checkCode;
}
