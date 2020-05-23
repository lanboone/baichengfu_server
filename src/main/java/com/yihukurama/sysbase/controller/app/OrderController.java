package com.yihukurama.sysbase.controller.app;


import com.yihukurama.sysbase.controller.app.dto.CommentChildrenDto;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.module.app.IAppOrder;
import com.yihukurama.sysbase.module.archives.domain.User;
import com.yihukurama.sysbase.module.archives.service.ISystem;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
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
@Api(value = "APP订单模块", tags = "APP订单模块")
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {



    @Autowired
    IAppOrder iAppOrder;

    @ApiOperation(value = "确认收货",notes = "确认收货")
    @RequestMapping(value = "/confirm_order", method = RequestMethod.POST)
    public Result confirmOrder(@RequestBody Request<OrderEntity> request) throws Exception {


        return iAppOrder.confirmOrder(request);
    }


}

