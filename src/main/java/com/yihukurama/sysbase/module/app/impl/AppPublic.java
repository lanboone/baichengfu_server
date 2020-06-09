package com.yihukurama.sysbase.module.app.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.controller.app.dto.ForgetPwdDto;
import com.yihukurama.sysbase.controller.app.dto.LoginDto;
import com.yihukurama.sysbase.controller.app.dto.RegistDto;
import com.yihukurama.sysbase.controller.app.dto.TokenLoginDto;
import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.Smstemplate;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserService;
import com.yihukurama.sysbase.thirdparty.sms.ISms;
import com.yihukurama.sysbase.thirdparty.tencent.wx.app.IWxappFeign;
import com.yihukurama.sysbase.thirdparty.tencent.wx.app.WxappConfig;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.businessservice.ISecurity;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 说明： APP公开服务
 * @author yihukurama
 * @date Created in 19:43 2020/3/26
 *       Modified by yihukurama in 19:43 2020/3/26
 */
@Service
public class AppPublic implements IAppPublic {
    @Autowired
    AppuserMapper appuserMapper;
    @Autowired
    ISms iSms;
    @Autowired
    RedisUtils redisUtils;

    @Autowired
    ISecurity iSecurity;

    @Override
    public Result forgetPwd(Request<ForgetPwdDto> request) throws TipsException {
        AppuserEntity reqAppuser = new Appuser();
        String phone = request.getData().getPhone();
        String pwd = request.getData().getPassword();
        String code = request.getData().getCheckCode();
        reqAppuser.setPhoneNumber(phone);

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(EmptyUtil.isEmpty(appuserEntityList)){
            return Result.failed(null,"该手机号未注册",-2);
        }
        reqAppuser = appuserEntityList.get(0);
        //进行验证码校验
        Boolean check = iSecurity.checkCode(phone,code);
        if(!check){
            return Result.failed(null,"验证码错误",-1);
        }
        reqAppuser.setUserName(phone);
        reqAppuser.setPhoneNumber(phone);
        pwd = iSecurity.pwdEncrypt(pwd);
        reqAppuser.setUserPassword(pwd);
        appuserService.update(reqAppuser);
        return Result.successed("重置密码成功");

    }

    @Override
    public Result appLogin(Request<LoginDto> request) throws TipsException {
        Appuser reqAppuser = new Appuser();
        List<AppuserEntity> appuserEntityList = null;
        AppuserEntity loginAppuser = null;
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-","");

        if(request.getData().getType() == LoginDto.TYPE_10){
            reqAppuser.setPhoneNumber(request.getData().getPhone());
            appuserEntityList = appuserService.list(reqAppuser);
            if(EmptyUtil.isEmpty(appuserEntityList)){
                //若为空，该手机号码未注册
                return Result.failed(null,"该手机号未注册",-3);
            }
            loginAppuser = appuserEntityList.get(0);
            String code = request.getData().getCheckCode();
            if(EmptyUtil.isEmpty(code)){
                return Result.failed("该登录方式验证码不可为空");
            }
            Boolean check = iSecurity.checkCode(request.getData().getPhone(),code);

            if(check){
                loginAppuser.setToken(token);
                appuserService.update(loginAppuser);
                return Result.successed(loginAppuser,"登录成功");
            }else{
                return Result.failed("验证码错误");
            }

        }else if(request.getData().getType() == LoginDto.TYPE_20){
            reqAppuser.setUserName(request.getData().getPhone());
            String pwd = iSecurity.pwdEncrypt(request.getData().getPassword());
            reqAppuser.setUserPassword(pwd);
            appuserEntityList = appuserService.list(reqAppuser);
            if(EmptyUtil.isEmpty(appuserEntityList)){
                return Result.failed(null,"用户名密码不正确",-3);
            }
            loginAppuser = appuserEntityList.get(0);
            if(loginAppuser.getIsLimitLogin()!=null && loginAppuser.getIsLimitLogin().equals(1)){
                return Result.failed(null,"后台已限制该账号登录",-50);
            }
            loginAppuser.setToken(token);
            appuserService.update(loginAppuser);
            return Result.successed(loginAppuser,"登录成功");
        }

        return Result.failed(null,"不明的登录方式",-1);
    }

    @Override
    public Result appSendMsg(Request<Smstemplate> request) {
        return null;
    }

    @Override
    public Result appLoginByToken(Request<TokenLoginDto> request) throws TipsException {
        Appuser reqAppuser = new Appuser();

        reqAppuser.setId(request.getData().getAppUserId());
        reqAppuser.setToken(request.getData().getToken());

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(EmptyUtil.isEmpty(appuserEntityList)){
            //若为空，该token已失效
            return Result.failed(null,"该token已失效",-4);
        }
        AppuserEntity loginAppuser = appuserEntityList.get(0);
        if(loginAppuser.getIsLimitLogin()!=null && loginAppuser.getIsLimitLogin().equals(1)){
            return Result.failed(null,"后台已限制该账号登录",-50);
        }
        return Result.successed(loginAppuser,"登录成功");
    }

    @Autowired
    AppuserService appuserService;
    @Override
    public Result appRegist(Request<RegistDto> request) throws TipsException {
        Appuser reqAppuser = new Appuser();
        String phone = request.getData().getPhone();
        String pwd = request.getData().getPassword();
        String code = request.getData().getCheckCode();
        reqAppuser.setPhoneNumber(phone);

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(!EmptyUtil.isEmpty(appuserEntityList)){
            //若不为空，该手机号码已注册
            return Result.failed(null,"该手机号已注册",-2);
        }

        //进行验证码校验
        Boolean check = iSecurity.checkCode(phone,code);
        if(!check){
            return Result.failed(null,"验证码错误",-1);
        }
        reqAppuser.setUserName(phone);
        reqAppuser.setPhoneNumber(phone);
        pwd = iSecurity.pwdEncrypt(request.getData().getPassword());
        reqAppuser.setUserPassword(pwd);
        //创建专属邀请码，16位uuid
        reqAppuser.setPersonalCode(NumberUtil.getOrderIdByUUId());
        AppuserEntity appuser = appuserService.create(reqAppuser);
        return Result.successed(appuser,"注册成功");
    }

    @Override
    public Result sendCode(Request<String> request) {

        String phone = request.getData();
        String random =iSecurity.generalCode(phone,6,600L);
        String result = iSms.sendCheckSms(phone,random+"##10");
        JSONObject jsonObject = JSON.parseObject(result);
        if(jsonObject.getInteger("code") == 0){
            return Result.successed(result,"发送验证码成功"+random);
        }
        return Result.failed("发送验证码失败");
    }

    @Override
    public Result checkCode(Request<Appuser> request) {

        String phone = request.getData().getPhoneNumber();
        String requestCode = request.getData().getCheckCode();

        if(redisUtils.exists(phone)){
            String code = (String) redisUtils.get(phone);
            if(code.equals(requestCode)){
                return Result.successed("校验通过");
            }
        }
        return Result.failed("","校验不通过",-1);
    }

    @Autowired
    IWxappFeign iWxappFeign;
    @Autowired
    WxappConfig wxappConfig;

    @Override
    public Result weChatLogin(String code) throws TipsException{

        String result = iWxappFeign.access_token(wxappConfig.getAppId(),
                wxappConfig.getAppSecret(),code,null);

        JSONObject resultJson = JSON.parseObject(result);
        String accessToken = resultJson.getString("access_token");
        if(EmptyUtil.isEmpty(accessToken)){
            return Result.failed(result,"微信登录失败,无法获取accesstoken",-1);
        }

        String openid = resultJson.getString("openid");
        if(!EmptyUtil.isEmpty(openid)){
            AppuserEntity appuserEntity = new AppuserEntity();
            appuserEntity.setWxappOpenid(openid);
            List<AppuserEntity> apps = appuserService.list(appuserEntity);
            if(EmptyUtil.isEmpty(apps)){
                return Result.failed(resultJson,"微信登录失败,该用户未注册",-2);
            }else if(apps.size() == 1){
                return Result.successed(apps.get(0),"微信登录成功");
            }
        }
        return Result.failed(result,"微信登录失败",-1);
    }

    @Override
    public Result thirdlogin(Request<Appuser> request) throws TipsException {
        Appuser reqAppuser = request.getData();

        if(EmptyUtil.isEmpty(reqAppuser.getWechatNumber()) && EmptyUtil.isEmpty(reqAppuser.getQq())){
            return Result.failed("必须指定qq和微信标识");
        }
        reqAppuser.setWechatNumber(request.getData().getWechatNumber());
        reqAppuser.setQq(request.getData().getQq());

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(EmptyUtil.isEmpty(appuserEntityList)){
            //若为空，该token已失效
            return Result.failed(null,"该qq或微信暂未注册，请先注册",-5);
        }
        AppuserEntity loginAppuser = appuserEntityList.get(0);
        if(loginAppuser.getIsLimitLogin()!=null && loginAppuser.getIsLimitLogin().equals(1)){
            return Result.failed(null,"后台已限制该账号登录",-50);
        }
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-","");
        loginAppuser.setToken(token);
        appuserService.update(loginAppuser);
        return Result.successed(loginAppuser,"登录成功");
    }

    @Override
    public Result thirdregist(Request<Appuser> request) throws TipsException {
        Appuser reqAppuser = new Appuser();
        String phone = request.getData().getUserName();
        String code = request.getData().getCheckCode();
        //进行验证码校验
        Boolean check = iSecurity.checkCode(phone,code);
        if(!check){
            return Result.failed(null,"验证码错误",-1);
        }
        reqAppuser.setPhoneNumber(phone);

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(!EmptyUtil.isEmpty(appuserEntityList)){
            //若不为空，该手机号码已注册,更新微信或qq信息
            appuserEntityList.get(0).setWechatNumber(request.getData().getWechatNumber());
            appuserEntityList.get(0).setQq(request.getData().getQq());
            String pwd = iSecurity.pwdEncrypt(request.getData().getUserPassword());
            appuserEntityList.get(0).setUserPassword(pwd);
            AppuserEntity appuser = appuserService.update(appuserEntityList.get(0));
            return Result.successed(appuser,"覆盖绑定成功");
        }
        reqAppuser.setQq(request.getData().getQq());
        reqAppuser.setWechatNumber(request.getData().getWechatNumber());
        reqAppuser.setUserName(phone);
        reqAppuser.setPhoneNumber(phone);
        String pwd = iSecurity.pwdEncrypt(request.getData().getUserPassword());
        reqAppuser.setUserPassword(pwd);
        //创建专属邀请码，16位uuid
        reqAppuser.setPersonalCode(NumberUtil.getOrderIdByUUId());
        AppuserEntity appuser = appuserService.create(reqAppuser);
        return Result.successed(appuser,"注册成功");
    }
}
