package com.yihukurama.sysbase.controller;


import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.IPublicApi;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 说明： 档案模块接口
 *
 * @author yihukurma
 * @date Created in 下午 1:21 2019/7/27 0027
 * modified by autor in 下午 1:21 2019/7/27 0027
 */
@Api(value = "Public API", tags = "公共API")
@RestController
@RequestMapping("/public")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PublicController  {

    @Autowired
    IPublicApi iPublicApi;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<User> request) throws Exception {



        return iPublicApi.login(request);
    }

    @RequestMapping(value = "/is_login", method = RequestMethod.POST)
    public Result isLogin(@RequestBody Request<User> request) throws Exception {



        return iPublicApi.isLogin(request);
    }

}

