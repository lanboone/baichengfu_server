package com.yihukurama.sysbase.controller;

import com.yihukurama.sysbase.controller.dto.EmsSearchDto;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.thirdparty.ems.EMS100Service;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 说明： 系统模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "系统回调接口", tags = "系统接口")
@RestController
@RequestMapping("/third_party")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ThirdPartyController {


    @Autowired
    EMS100Service ems100Service;

    @ApiOperation(value = "快递查询接口", notes = "快递查询接口")
    @RequestMapping(value = "/ems_search", method = RequestMethod.POST)
    public String emsSearch(@RequestBody Request<EmsSearchDto> request) throws Exception {

        return ems100Service.searchEms(request.getData().getCom(),request.getData().getNum());
    }
}
