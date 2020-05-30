package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.domain.OrderProduct;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明： Order的领域服务
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class OrderService extends CrudService<OrderEntity>{

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    StandardConfigService standardConfigService;

    @Autowired
    AppuserService appuserService;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderEntity create(OrderEntity orderEntity) throws TipsException {
        List<OrderProductEntity> resultOrderProduct = new ArrayList<>();
        //创建单号
        orderEntity.setNum(NumberUtil.getNum());
        //寻找上线
        AppuserEntity appuserEntity = new AppuserEntity();
        appuserEntity.setId(orderEntity.getAppuserId());
        appuserEntity = appuserService.load(appuserEntity);
        String appuserParentId = appuserEntity.getParentId();
        if(!EmptyUtil.isEmpty(appuserParentId)){
            orderEntity.setAppuserParentId(appuserParentId);
        }
        //查看积分抵扣
        Integer integral = appuserEntity.getIntegral();
        if(integral == null){
            integral = 0;
        }
        Integer totalConsumPoint = orderEntity.getConsumPoint() == null? 0 : orderEntity.getConsumPoint();

        if(totalConsumPoint<integral){
            throw new TipsException("用户积分不足");
        }
        OrderEntity resultOrderEntity = super.create(orderEntity);

        if(orderEntity instanceof Order){
            Order order = (Order) orderEntity;
            List<OrderProductEntity> orderProductEntityList = order.getOrderProducts();
            if(EmptyUtil.isEmpty(orderProductEntityList)){
                throw new TipsException("创建订单时必须要有关联的商品");
            }
            //计算价格
            BigDecimal totalPrice = new BigDecimal(0);
            Integer totalPoint = 0;
            for (int i = 0; i < orderProductEntityList.size(); i++) {
                OrderProductEntity  orderProductEntity = orderProductEntityList.get(i);
                String standConfigId = orderProductEntity.getStandConfigId();
                if(EmptyUtil.isEmpty(standConfigId)){
                    throw new TipsException("订单商品中没有 standConfigId");
                }
                StandardConfigEntity standardConfigEntity = new StandardConfigEntity();
                standardConfigEntity.setId(standConfigId);
                standardConfigEntity = standardConfigService.load(standardConfigEntity);
                if(standardConfigEntity == null){
                    throw new TipsException("没有该规格商品");
                }
                BigDecimal productPrict = standardConfigEntity.getPrice();
                Integer genPoint = standardConfigEntity.getPoint() == null ? 0 : standardConfigEntity.getPoint();
                orderProductEntity.setProductPic(standardConfigEntity.getPictureUrl());
                orderProductEntity.setMarketPrice(standardConfigEntity.getMarketPrice());
                orderProductEntity.setPrice(standardConfigEntity.getPrice());
                if(orderProductEntity.getCount() == null){
                    throw new TipsException("订单商品无数量");
                }
                productPrict = productPrict.multiply(new BigDecimal(orderProductEntity.getCount()));
                totalPrice = totalPrice.add(productPrict);
                genPoint = genPoint*orderProductEntity.getCount();
                totalPoint = totalPoint+genPoint;
                orderProductEntity.setOrderId(resultOrderEntity.getId());
                if(!EmptyUtil.isEmpty(appuserParentId)){
                    orderProductEntity.setAppuserParentId(appuserParentId);
                }
                OrderProductEntity resultOrderProductEntity = orderProductService.create(orderProductEntity);
                resultOrderProduct.add(resultOrderProductEntity);
            }
            totalPrice = totalPrice.add(orderEntity.getFreight());
            orderEntity.setPaidPrice(totalPrice.subtract(new BigDecimal(totalConsumPoint)));
            orderEntity.setOrderPrice(totalPrice);
            orderEntity.setGenPoint(totalPoint);
            //更新订单金额
            super.update(orderEntity);
            //更新个人积分
            appuserEntity = new AppuserEntity();
            appuserEntity.setId(orderEntity.getAppuserId());
            appuserEntity.setIntegral(integral-totalConsumPoint);
            appuserService.update(appuserEntity);
        }
        Order order = TransferUtils.transferEntity2Domain(resultOrderEntity,Order.class);
        order.setOrderProducts(resultOrderProduct);
        return order;
    }


    @Override
    public Result list(OrderEntity orderEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(orderEntity, page, limit);

        List<Order> orderList = new ArrayList<>();
        if(orderEntity instanceof Order){
            Order order = (Order) orderEntity;
            Integer type = order.getSearchType();
            if(type!=null && Order.SEARCH_TYPE_10 == type){
                //带出商品详情
                List<OrderEntity> orderEntityList = (List<OrderEntity>) result.getData();
                if(EmptyUtil.isEmpty(orderEntityList)){
                    return result;
                }
                for (int i = 0; i < orderEntityList.size(); i++) {
                    Order tmpOrder = TransferUtils.transferEntity2Domain(orderEntityList.get(i),Order.class);
                    //查询该订单关联的所有商品数据
                    OrderProductEntity orderProductEntity = new OrderProductEntity();
                    orderProductEntity.setOrderId(orderEntityList.get(i).getId());
                    List<OrderProductEntity> orderProductEntities = orderProductService.list(orderProductEntity);
                    tmpOrder.setOrderProducts(orderProductEntities);
                    orderList.add(tmpOrder);
                }
            }
        }
        result.setData(orderList);
        return result;
    }


    @Override
    public OrderEntity load(OrderEntity orderEntity) throws TipsException {
        orderEntity = super.load(orderEntity);
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderId(orderEntity.getId());
        List<OrderProductEntity>  orderProductEntities = orderProductService.list(orderProductEntity);
        Order order = TransferUtils.transferEntity2Domain(orderEntity,Order.class);
        order.setOrderProducts(orderProductEntities);
        return order;
    }

    /**
     * 获取所有订单商品
     * @param orderEntity
     * @return
     * @throws TipsException
     */
    public List<OrderProductEntity> doGetOrderProducts(@NotNull OrderEntity orderEntity) throws TipsException {
        orderEntity = this.load(orderEntity);
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderId(orderEntity.getId());
        return orderProductService.list(orderProductEntity);
    }
}
