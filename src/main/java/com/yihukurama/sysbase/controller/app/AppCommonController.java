package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.IPublicApi;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
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
@Api(value = "APP通用模块", tags = "APP接口")
@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppCommonController {


    @Autowired
    IAppPublic iAppPublic;
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Result regist(@RequestBody Request<Appuser> request) throws Exception {

        Appuser appuser = request.getData();
        if(EmptyUtil.isEmpty(appuser.getUserName()) || EmptyUtil.isEmpty(appuser.getCheckCode())){
            return Result.failed(null,"手机号验证码不可为空",-1);
        }

        return iAppPublic.appRegist(request);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<Appuser> request) throws Exception {
        Appuser appuser = request.getData();
        if(EmptyUtil.isEmpty(appuser.getUserName()) || EmptyUtil.isEmpty(appuser.getUserPassword())){
            return Result.failed(null,"用户名密码不可为空",-1);
        }

        return iAppPublic.appLogin(request);
    }


    @RequestMapping(value = "/login_by_token", method = RequestMethod.POST)
    public Result loginByToken(@RequestBody Request<Appuser> request) throws Exception {

        Appuser appuser = request.getData();
        if(EmptyUtil.isEmpty(appuser.getToken())){
            return Result.failed(null,"token不可为空",-1);
        }

        return iAppPublic.appLoginByToken(request);
    }


}

