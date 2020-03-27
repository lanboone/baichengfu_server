package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.module.app.IAppPublic;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.Smstemplate;
import com.yihukurama.sysbase.module.archives.service.domainservice.AppuserService;
import com.yihukurama.sysbase.thirdparty.sms.ISms;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Result appLogin(Request<Appuser> request) throws TipsException {
        Appuser reqAppuser = new Appuser();
        reqAppuser.setPhoneNumber(request.getData().getPhoneNumber());

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(EmptyUtil.isEmpty(appuserEntityList)){
            //若为空，该手机号码未注册
            return Result.failed(null,"该手机号未注册",-3);
        }
        AppuserEntity loginAppuser = appuserEntityList.get(0);
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-","");
        loginAppuser.setToken(token);
        appuserService.update(loginAppuser);
        return Result.successed(loginAppuser,"登录成功");
    }

    @Override
    public Result appSendMsg(Request<Smstemplate> request) {
        return null;
    }

    @Override
    public Result appLoginByToken(Request<Appuser> request) throws TipsException {
        Appuser reqAppuser = new Appuser();

        reqAppuser.setId(request.getData().getId());
        reqAppuser.setToken(request.getData().getToken());

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(EmptyUtil.isEmpty(appuserEntityList)){
            //若为空，该token已失效
            return Result.failed(null,"该token已失效",-4);
        }
        AppuserEntity loginAppuser = appuserEntityList.get(0);

        return Result.successed(loginAppuser,"登录成功");
    }

    @Autowired
    AppuserService appuserService;
    @Override
    public Result appRegist(Request<Appuser> request) throws TipsException {
        Appuser reqAppuser = new Appuser();
        reqAppuser.setPhoneNumber(request.getData().getPhoneNumber());

        List<AppuserEntity> appuserEntityList = appuserService.list(reqAppuser);
        if(!EmptyUtil.isEmpty(appuserEntityList)){
            //若不为空，该手机号码已注册
            return Result.failed(null,"该手机号已注册",-2);
        }
        reqAppuser = request.getData();
        AppuserEntity appuser = appuserService.create(reqAppuser);
        return Result.successed(appuser,"注册成功");

    }


    @Override
    public Result sendCode(Request<Appuser> request) {

        String phone = request.getData().getPhoneNumber();
        String random = "123";
        String content = "您的验证码为"+random;
        String result = iSms.sendSms(phone,content);
        //缓存10分钟
        redisUtils.set(phone,content,60*10L);
        return Result.successed("发送验证码成功");
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
}
