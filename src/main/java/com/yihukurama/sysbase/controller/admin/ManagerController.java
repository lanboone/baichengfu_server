package com.yihukurama.sysbase.controller.admin;

import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.controller.app.dto.LoginDto;
import com.yihukurama.sysbase.module.admin.Manager;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: liyuan
 * @date: 2020/4/2 17:01
 * @description: 管理员相关接口
 */
@Api(value = "Manager Controller", tags = "管理员相关接口")
@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ManagerController {

    @Resource
    Manager manager;

    @ApiOperation(value = "登录接口",notes = "用户名密码必传-密码前端加密")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<LoginDTO> request) throws Exception {
        return manager.adminLogin(request);
    }
}
