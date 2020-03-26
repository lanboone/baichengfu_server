package com.yihukurama.sysbase.module.archives.service.impl;

import com.yihukurama.sysbase.common.enums.ResponseEnum;
import com.yihukurama.sysbase.mapper.UserMapper;
import com.yihukurama.sysbase.mapper.UserroleMapper;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.Configuration;
import com.yihukurama.sysbase.module.archives.domain.Roleprivilege;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.IPublicApi;
import com.yihukurama.sysbase.module.archives.service.domainservice.*;
import com.yihukurama.tkmybatisplus.app.cache.RedisUtils;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.security.AbstractJwtTokenGenerator;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.InfoUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.businessservice.ISecurity;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 说明： 公共api接口实现
 *
 * @author: ouyaokun
 * @date: Created in 17:00 2018/12/11
 * @modified: by autor in 17:00 2018/12/11
 */
@Service
public class PublicApiService implements IPublicApi {

    @Autowired
    ISecurity securityService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserService userService;
    @Autowired
    ConfigurationService configurationService;
    @Autowired
    UserroleMapper userroleMapper;
    @Autowired
    MenuService menuService;
    @Autowired
    FuncService funcService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleprivilegeService roleprivilegeService;



    @Override
    public Result login(Request<User> request) throws TipsException {
        //获取登录超时时间
        String loginExpiretimeStr =configurationService.doGetValueByCode(Configuration.LOGIN_EXPIRETIME);
        Long loginExpiretime = Long.valueOf(loginExpiretimeStr);
        User user = request.getData();
        if (user == null || EmptyUtil.isEmpty(user.getUsername()) || EmptyUtil.isEmpty(user.getPassword())) {
            return Result.failed(null,"账户或用户名为空，请检查", ResponseEnum.ERROR_CODE_4005.getCode());
        }
        //密码加密
        String encryptPwd = securityService.pwdEncrypt(user.getPassword());
        user.setPassword(encryptPwd);

        List<UserEntity> userEntitys = userService.list(user);
        if (userEntitys == null || userEntitys.size() != 1) {
            return Result.failed(null,"账号或密码错误，请检查",-1);
        }

        UserEntity userEntity = userEntitys.get(0);
        if (User.STATUS_2.equals(user.getStatus())){
            return Result.failed(null,"该账号已经禁用",-1);
        }
        //获取用户角色
        UserroleEntity userroleEntity = new UserroleEntity();
        userroleEntity.setUserId(userEntity.getId());
        List<UserroleEntity> userroleEntities = userroleMapper.select(userroleEntity);
        List<String> roleIds=new ArrayList<>();
        List<MenuEntity> menus=new ArrayList<>();
        List<FuncEntity> funcs=new ArrayList<>();
        for (UserroleEntity entity : userroleEntities) {
            roleIds.add(entity.getRoleId());
            //获取用户可访问菜单
            RoleprivilegeEntity roleprivilegeEntity = new RoleprivilegeEntity();
            roleprivilegeEntity.setRoleId(entity.getRoleId());
            List<RoleprivilegeEntity> list = roleprivilegeService.list(roleprivilegeEntity);
            for (RoleprivilegeEntity roleprivileget : list) {
                if (Roleprivilege.QXLX_1.equals(roleprivileget.getType())) {
                    MenuEntity menuEntity = new MenuEntity();
                    menuEntity.setId(roleprivileget.getPrivilegeId());
                    MenuEntity load = menuService.load(menuEntity);
                    if (load == null) {
                        continue;
                    }
                    menus.add(load);
                } else if (Roleprivilege.QXLX_2.equals(roleprivileget.getPrivilegeId())) {
                    FuncEntity func = new FuncEntity();
                    func.setId(roleprivileget.getPrivilegeId());
                    FuncEntity load = funcService.load(func);
                    if (load == null) {
                        continue;
                    }
                    funcs.add(load);
                }
            }
        }


        User loginUser = TransferUtils.transferEntity2Domain(userEntity,User.class);
        loginUser.setMenus(menus);
        loginUser.setFuncs(funcs);
        //设置token，先删除旧token
        if(!EmptyUtil.isEmpty(loginUser.getToken())){
            String oldToken = loginUser.getToken();
            redisUtils.remove(oldToken);
        }
        Long timeStamp = System.currentTimeMillis();
        String token = AbstractJwtTokenGenerator.generateToken(loginUser, timeStamp.toString());
        loginUser.setToken(token);
        loginUser.setLastLoginDate(new Date());
        loginUser.setLoginCount(loginUser.getLoginCount() + 1);
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httprequest = sra.getRequest();
        loginUser.setIpAddr(InfoUtil.getIpAddr(httprequest));
        loginUser.setOperatorId(loginUser.getId());
        //不能用userService跟新，否则会进行两次加密
        userMapper.updateByPrimaryKey(loginUser);
        loginUser.setMenus(menus);
        loginUser.setFuncs(funcs);

        loginUser.setSecret(token);
        redisUtils.set(token, loginUser.getId(), loginExpiretime);
        redisUtils.set(loginUser.getId(),loginUser, loginExpiretime);

        loginUser.setCurrentAuthority("user");
        return Result.successed(loginUser, "登录成功");
    }

    @Override
    public Result isLogin(Request<User> request) {
        User user = request.getData();
        if (user == null || EmptyUtil.isEmpty(user.getToken())){
            return Result.failed("参数不能为空");
        }
        if(redisUtils.exists(user.getToken())){
            String uid = (String) redisUtils.get(user.getToken());
            if(redisUtils.exists(uid)){
                User loginUser = (User) redisUtils.get(uid);
                return Result.successed(loginUser);
            }
        }

        return Result.failed("未登录");
    }

}
