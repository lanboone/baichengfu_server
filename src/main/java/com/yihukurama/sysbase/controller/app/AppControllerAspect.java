package com.yihukurama.sysbase.controller.app;

import com.alibaba.fastjson.JSON;
import com.yihukurama.sysbase.bean.config.SystemConfig;
import com.yihukurama.sysbase.common.utils.StringUtil;
import com.yihukurama.sysbase.handle.DateUtil;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 说明： app接口拦截器
 * @author dengs
 * @date Created in 19:38 2020/4/20
 *       Modified by dengs in 19:38 2020/4/20
 */
@Aspect
@Component
public class AppControllerAspect {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    SystemConfig systemConfig;

    @Around("execution(com.yihukurama.tkmybatisplus.framework.web.dto.Result com.yihukurama.tkmybatisplus.framework.web.CommController.*(..)) || execution(com.yihukurama.tkmybatisplus.framework.web.dto.Result com.yihukurama.sysbase.controller.app..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest hsRequest = sra.getRequest();
        String url = hsRequest.getRequestURL().toString();
        String token = hsRequest.getHeader("token");


        Request request = null;
        String simpleMethodName = pjp.getSignature().getName();
        String userId = "";
        Date now = DateUtil.now();
        Object[] os = pjp.getArgs();
        LogUtil.debugLog(this,"进入app拦截器");
        for (int i = 0; i < os.length; i++) {
            if (os[i] instanceof Request) {
                request = (Request) os[i];
                if (request == null) {
                    return Result.failed("请求参数request不能为空");
                }

                //设置token
                request.setToken(token);

//                if (EmptyUtil.isEmpty(request.getToken())) {
//                    return Result.failed("请求参数中没有token!收到的请求是>>>>>" + JSON.toJSONString(request));
//                }

                if (simpleMethodName.startsWith("list")) {
                    //改变做法，page为空 自动添加page
                    if (request.getPage() == null) {
                        request.setPage(0);
                        request.setLimit(15);
                    }
                }

                if (request.getPage() != null && request.getPage() > 0 && request.getLimit() != null
                        && request.getLimit() <= 0) {
                    return Result.failed("page参数大于0时,limit参数必须大于0");
                }

                break;
            }
        }

        Object object = null;
        String tips = "";
        try {
            object = pjp.proceed();

        } catch (Throwable e) {
            if (e instanceof ClassNotFoundException) {
                tips = "请检查路径是否合法!";
            }

            if (e != null && e.getMessage() != null && !"".equals(e.getMessage())) {
                tips += e.getMessage();
                LogUtil.errorLog(this, tips);
            } else {
                tips += "后台异常信息为:" + StringUtil.exceptionToString(e);
                LogUtil.errorLog(this, tips);
            }
            return Result.failed(tips);
        }


        return object;
    }
}
