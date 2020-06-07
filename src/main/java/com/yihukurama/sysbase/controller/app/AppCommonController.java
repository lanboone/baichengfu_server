package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.controller.app.dto.ForgetPwdDto;
import com.yihukurama.sysbase.controller.app.dto.LoginDto;
import com.yihukurama.sysbase.controller.app.dto.RegistDto;
import com.yihukurama.sysbase.controller.app.dto.TokenLoginDto;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@Api(value = "APP通用模块", tags = "APP接口")
@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppCommonController {


    @Autowired
    IAppPublic iAppPublic;

    /**
     * @throws
     * @title weChatLogin
     * @description 微信授权登录
     * @author Kuangzc
     * @updateTime 2019-9-12 16:00:51
     */
    @ApiOperation(value = "微信授权登录")
    @ApiImplicitParams({
    @ApiImplicitParam(paramType = "query", name = "code", value = "用户换取access_token的code，仅在ErrCode为0时有效", required = true, dataType = "String")
    })
    @GetMapping("/weChatLogin")
    protected Result weChatLogin(@RequestParam String code) throws TipsException {

        return iAppPublic.weChatLogin(code);
    }
    @ApiOperation(value = "发送短信验证码",notes = "手机号必传")
    @RequestMapping(value = "/send_smscode", method = RequestMethod.POST)
    public Result sendSmscode(@RequestBody Request<String> request) throws Exception {


        return iAppPublic.sendCode(request);
    }

    @ApiOperation(value = "手机校验",notes = "手机号和验证码必传")
    @RequestMapping(value = "/check_code", method = RequestMethod.POST)
    public Result checkCode(@RequestBody Request<Appuser> request) throws Exception {

        Appuser appuser = request.getData();
        if(EmptyUtil.isEmpty(appuser.getPhoneNumber() )|| EmptyUtil.isEmpty(appuser.getCheckCode())){
            return Result.failed(null,"手机号和验证码不可为空",-1);
        }

        return iAppPublic.checkCode(request);
    }

    @ApiOperation(value = "注册接口",notes = "传入用户信息进行注册，手机号必传")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Result regist(@RequestBody Request<RegistDto> request) throws Exception {


        return iAppPublic.appRegist(request);
    }

    @ApiOperation(value = "登录接口",notes = "用户名密码必传")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<LoginDto> request) throws Exception {


        return iAppPublic.appLogin(request);
    }

    @ApiOperation(value = "token登录",notes = "用户id和token必传")
    @RequestMapping(value = "/login_by_token", method = RequestMethod.POST)
    public Result loginByToken(@RequestBody Request<TokenLoginDto> request) throws Exception {



        return iAppPublic.appLoginByToken(request);
    }


    @ApiOperation(value = "忘记密码",notes = "用户id和token必传")
    @RequestMapping(value = "/forget_pwd", method = RequestMethod.POST)
    public Result forgetPwd(@RequestBody Request<ForgetPwdDto> request) throws Exception {


        return iAppPublic.forgetPwd(request);
    }


    @ApiOperation(value = "三方登录接口",notes = "微信号或qq号必传")
    @RequestMapping(value = "/thirdlogin", method = RequestMethod.POST)
    public Result thirdlogin(@RequestBody Request<Appuser> request) throws Exception {


        return iAppPublic.thirdlogin(request);
    }

    @ApiOperation(value = "三方注册接口",notes = "微信号或qq号，手机号验证码必传")
    @RequestMapping(value = "/thirdregist", method = RequestMethod.POST)
    public Result thirdregist(@RequestBody Request<Appuser> request) throws Exception {


        return iAppPublic.thirdregist(request);
    }

}

