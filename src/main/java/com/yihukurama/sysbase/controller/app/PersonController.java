package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.controller.app.dto.FocusDesignerDto;
import com.yihukurama.sysbase.model.AppuserDesignerEntity;
import com.yihukurama.sysbase.module.app.IPerson;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserDesigner;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
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
@Api(value = "APP个人中心", tags = "APP个人中心")
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {

    @Autowired
    IPerson person;

    @ApiOperation(value = "关注设计师",notes = "关注设计师，传入设计师的designerId和自己的appuserId")
    @RequestMapping(value = "/focus_designer", method = RequestMethod.POST)
    public Result focusDesigner(@RequestBody Request<FocusDesignerDto> request) throws Exception {



        return person.focusDesigner(request);
    }

    @ApiOperation(value = "取消关注设计师",notes = "关注设计师，传入设计师的designerId和自己的appuserId")
    @RequestMapping(value = "/un_focus_designer", method = RequestMethod.POST)
    public Result unFocusDesigner(@RequestBody Request<FocusDesignerDto> request) throws Exception {



        return person.unFocusDesigner(request);
    }

}

