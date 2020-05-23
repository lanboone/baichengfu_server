package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.domain.OrderProduct;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

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
        OrderEntity resultOrderEntity = super.create(orderEntity);

        if(orderEntity instanceof Order){
            Order order = (Order) orderEntity;
            List<OrderProductEntity> orderProductEntityList = order.getOrderProducts();
            if(EmptyUtil.isEmpty(orderProductEntityList)){
                throw new TipsException("创建订单时必须要有关联的商品");
            }
            //计算价格
            BigDecimal totalPrice = new BigDecimal(0);
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
                BigDecimal productPrict = new BigDecimal(standardConfigEntity.getPrice());
                orderProductEntity.setProductPic(standardConfigEntity.getPrice());
                orderProductEntity.setMarketPrice(standardConfigEntity.getMarketPrice());
                orderProductEntity.setPrice(standardConfigEntity.getPrice());
                totalPrice = totalPrice.add(productPrict);
                orderProductEntity.setOrderId(resultOrderEntity.getId());
                if(!EmptyUtil.isEmpty(appuserParentId)){
                    orderProductEntity.setAppuserParentId(appuserParentId);
                }
                OrderProductEntity resultOrderProductEntity = orderProductService.create(orderProductEntity);
                resultOrderProduct.add(resultOrderProductEntity);
            }
            orderEntity.setPaidPrice(totalPrice);
            orderEntity.setOrderPrice(totalPrice);
            //更新订单金额
            super.update(orderEntity);
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
}
