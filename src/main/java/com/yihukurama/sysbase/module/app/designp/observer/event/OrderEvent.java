package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.mapper.ProductAnalyseMapper;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.sysbase.model.ProductAnalyseEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.domain.OrderProduct;
import com.yihukurama.sysbase.module.archives.domain.ProductAnalyse;
import com.yihukurama.sysbase.module.archives.domain.StandardConfig;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderService;
import com.yihukurama.sysbase.module.archives.service.domainservice.ProductAnalyseService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.CollectionUtils;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明： 订单事件
 * @author yihukurama
 * @date Created in 16:50 2020/4/19
 *       Modified by yihukurama in 16:50 2020/4/19
 */
public class OrderEvent extends ApplicationEvent {
    
    /**
     * 出售订单事件
     */
    public final static int TYPE_30 = 30;

    private Integer type;

    public OrderEvent(Object source) {
        super(source);
    }


    public OrderEvent(Object source, Integer type) {
        super(source);
        this.type = type;
    }


    public void handleEvent(){
        switch (type){
            case TYPE_30:
                try {
                    soldOrder();
                } catch (TipsException e) {
                    LogUtil.errorLog(this,"销售订单事件报错");
                }
                break;

            default:
        }
    }

    /**
     * 出售订单事件
     */
    private void soldOrder() throws TipsException {
        if (!(source instanceof Order)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 Order");
            return;
        }

        Order order = (Order) source;
        OrderService orderService = (OrderService) SpringBeanTools.getBean(OrderService.class);
        List<OrderProductEntity> orderProductEntities = new ArrayList<>();
        try {
            orderProductEntities = orderService.doGetOrderProducts(order);
        } catch (TipsException e) {
            e.printStackTrace();
        }
        ProductAnalyseService productAnalyseService = (ProductAnalyseService) SpringBeanTools.getBean(ProductAnalyseService.class);

        //获取商品详细规格
        if(!CollectionUtils.isEmpty(orderProductEntities)){
            for (int i = 0; i < orderProductEntities.size(); i++) {
                OrderProductEntity orderProductEntity = orderProductEntities.get(i);
                //构造统计表
                ProductAnalyseEntity productAnalyse = new ProductAnalyseEntity();
                productAnalyse.setStandardId(orderProductEntity.getStandConfigId());
                List<ProductAnalyseEntity> productAnalyseEntities = productAnalyseService.list(productAnalyse);
                if(CollectionUtils.isEmpty(productAnalyseEntities)){
                    productAnalyseService.create(productAnalyse);
                }else {
                    //更新
                    productAnalyse = productAnalyseEntities.get(0);
                    productAnalyse.setSoldNumCount(NumberUtil.NullPlus(productAnalyse.getSoldNumCount(),1));
                    productAnalyse.setSoldPriceCount(NumberUtil.NullPlus(productAnalyse.getSoldPriceCount(),1));
                    productAnalyse.setAvg(productAnalyse.getSoldPriceCount()/productAnalyse.getSoldNumCount());
                    productAnalyseService.update(productAnalyse);

                }

            }
        }


    }

}
