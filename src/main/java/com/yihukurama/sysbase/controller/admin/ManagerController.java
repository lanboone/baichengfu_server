package com.yihukurama.sysbase.controller.admin;

import com.yihukurama.sysbase.controller.admin.dto.DeleteOperateDTO;
import com.yihukurama.sysbase.controller.admin.dto.LoginDTO;
import com.yihukurama.sysbase.controller.admin.dto.ManagerModifyDTO;
import com.yihukurama.sysbase.controller.admin.dto.ModifyPassWordDTO;
import com.yihukurama.sysbase.model.OperatelogEntity;
import com.yihukurama.sysbase.module.admin.IManager;
import com.yihukurama.sysbase.module.archives.domain.Operatelog;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.service.domainservice.OperatelogService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

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
    IManager manager;

    @ApiOperation(value = "登录接口", notes = "用户名密码必传-密码前端加密")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Request<LoginDTO> request) throws Exception {
        return manager.adminLogin(request);
    }

    @ApiOperation(value = "修改用户名+手机号", notes = "修改用户名+手机号-带校验")
    @RequestMapping(value = "/modifyNameAndPhone", method = RequestMethod.POST)
    public Result modifyNameAndPhone(@RequestBody Request<ManagerModifyDTO> request) throws Exception {
        return manager.modifyNameAndPhone(request);
    }

    @ApiOperation(value = "修改密码接口", notes = "修改密码接口-带检验-前端加密")
    @RequestMapping(value = "/modifyPassWord", method = RequestMethod.POST)
    public Result modifyPassWord(@RequestBody Request<ModifyPassWordDTO> request) throws Exception {
        return manager.modifyPassWord(request);
    }

    @ApiOperation(value = "token登录", notes = "用户id和token必传")
    @RequestMapping(value = "/loginByToken", method = RequestMethod.POST)
    public Result loginByToken(@Validated @NotBlank(message = "manager id can not be null") @RequestParam String id ,
                               @Validated @NotBlank(message = "token can not be null") @RequestParam String token) throws Exception {
        return manager.managerLoginByToken(id,token);
    }

    @Autowired
    OperatelogService operatelogService;
    
    @ApiOperation(value = "删除三个月或六个月的操作记录", notes = "删除三个月或六个月的操作记录")
    @RequestMapping(value = "/delete_operate", method = RequestMethod.POST)
    public Result deleteOperate(@RequestBody Request<DeleteOperateDTO> request) throws Exception {
        Integer type = request.getData().getMonth();
        if(type == null || (!type.equals(6) && !type.equals(3))){
            return Result.failed("参数错误，需要传入6或3");
        }
        OperatelogEntity operatelogEntity = new OperatelogEntity();
        Date toDate = new Date(System.currentTimeMillis());
        
        List<OperatelogEntity> operatelogEntityList = operatelogService.list(operatelogEntity);
        if (CollectionUtils.isEmpty(operatelogEntityList)){
            for (int i = 0; i <operatelogEntityList.size() ; i++) {
                Date opDate = operatelogEntityList.get(i).getCreateDate();
                long diff = toDate.getTime() - opDate.getTime();
                long diffDays = diff / (24 * 60 * 60 * 1000);
                if(diffDays >= type*30){
                    operatelogService.remove(operatelogEntityList.get(i));
                }
            }
        }
        
        return Result.successed("删除成功");
    }
}
