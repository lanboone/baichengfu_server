package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.sysbase.module.archives.service.domainservice.OrderService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;

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
                soldOrder();
                break;

            default:
        }
    }

    /**
     * 出售订单事件
     */
    private void soldOrder() {
        if (!(source instanceof Order)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 Order");
            return;
        }

        Order order = (Order) source;
        OrderService orderService = (OrderService) SpringBeanTools.getBean(OrderService.class);

        try {
            orderService.doGetOrderProducts(order);
        } catch (TipsException e) {
            e.printStackTrace();
        }
        //获取商品详细规格



    }

}
