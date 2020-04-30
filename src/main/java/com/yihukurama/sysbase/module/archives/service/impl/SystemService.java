package com.yihukurama.sysbase.module.archives.service.impl;

import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明： 系统服务
 * @author yihukurama
 * @date Created in 15:26 2020/2/10
 *       Modified by yihukurama in 15:26 2020/2/10
 */
@Service
public class SystemService implements ISystem {

    @Autowired
    RedisUtils redisUtils;


    @Override
    public Result changePassword(Request<User> request) throws TipsException {
        return null;
    }

    @Override
    public Result logout(Request<User> request) throws TipsException {
        User user = request.getData();
        String token = user.getToken();
        if(redisUtils.exists(user.getToken())){
            String uid = (String) redisUtils.get(user.getToken());
            redisUtils.remove(token);
            if(redisUtils.exists(uid)){
                redisUtils.remove(uid);
            }
        }
        return Result.successed("登出成功");
    }
}
