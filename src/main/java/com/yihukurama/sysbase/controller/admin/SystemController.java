package com.yihukurama.sysbase.controller.admin;


import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 说明： 系统模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "System API", tags = "系统API")
@RestController
@RequestMapping("/system")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemController {


    @Autowired
    ISystem iSystem;
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(@RequestBody Request<User> request) throws Exception {

        return iSystem.logout(request);
    }

}

