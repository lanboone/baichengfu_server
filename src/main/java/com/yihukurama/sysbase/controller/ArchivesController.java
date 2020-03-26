package com.yihukurama.sysbase.controller;


import com.yihukurama.tkmybatisplus.framework.web.CommController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明： 档案模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "Archives API", tags = "基础档案 通用API")
@RestController
@RequestMapping("/base")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArchivesController extends CommController {

    public ArchivesController() {
        packageDomainPath = "com.yihukurama.sysbase.module.archives.domain.";
        domainServicePath = "com.yihukurama.sysbase.module.archives.service.domainservice.";
    }


}

