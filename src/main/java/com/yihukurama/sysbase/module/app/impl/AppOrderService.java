package com.yihukurama.sysbase.module.app.impl;

import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.app.IAppOrder;
import com.yihukurama.sysbase.module.archives.domain.Appuser;
import com.yihukurama.sysbase.module.archives.domain.AppuserSell;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.domain.ProductCategories;
import com.yihukurama.sysbase.module.archives.service.domainservice.*;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Request;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AppOrderService implements IAppOrder {


    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    AppuserService appuserService;

    @Autowired
    ProductCategoriesService productCategoriesService;


    @Autowired
    AppuserSellService appuserSellService;

    @Override
    public Result confirmOrder(Request<OrderEntity> request) throws TipsException {
        OrderEntity orderEntity = request.getData();
        orderEntity = orderService.load(orderEntity);
        List<OrderProductEntity> orderProducts = orderService.doGetOrderProducts(orderEntity);
        if(!CollectionUtils.isEmpty(orderProducts)){
            for (int i = 0; i < orderProducts.size(); i++) {
                OrderProductEntity orderProductEntity = orderProducts.get(i);
                String productId = orderProductEntity.getProductId();
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(productId);
                productEntity = productService.load(productEntity);
                String categoriesId = productEntity.getCategoriesId();
                ProductCategoriesEntity productCategoriesEntity = new ProductCategoriesEntity();
                productCategoriesEntity.setId(categoriesId);
                productCategoriesEntity = productCategoriesService.load(productCategoriesEntity);
                Integer point = productCategoriesEntity.getPoint();
                if(point != null){
                    //需要创建分销记录单
                    AppuserSellEntity appuserSellEntity = new AppuserSellEntity();
                    appuserSellEntity.setAppuserId(orderEntity.getAppuserParentId());
                    appuserSellEntity.setBuyerId(orderEntity.getAppuserId());
                    appuserSellEntity.setNum(orderEntity.getNum());
                    appuserSellEntity.setOrderProductId(orderProductEntity.getId());
                    appuserSellEntity.setPayType(orderEntity.getPayType());
                    appuserSellEntity.setOrderNum(orderEntity.getTradeNo());
                    appuserSellEntity.setPrice(orderProductEntity.getPrice());
                    appuserSellEntity.setPoint(point);
                    appuserSellEntity.setProductPic(productEntity.getCoverImages());
                    appuserSellEntity.setProductId(productEntity.getId());
                    String appuserId = orderEntity.getAppuserId();
                    AppuserEntity appuserEntity = new AppuserEntity();
                    appuserEntity.setId(appuserId);
                    appuserEntity = appuserService.load(appuserEntity);
                    appuserSellEntity.setBuyerName(appuserEntity.getNickName());
                    appuserSellService.create(appuserSellEntity);
                }
            }
        }
        orderEntity.setStatus(Order.PAY_STATUS_40);
        orderService.update(orderEntity);
        return Result.successed("确认成功");
    }
}
