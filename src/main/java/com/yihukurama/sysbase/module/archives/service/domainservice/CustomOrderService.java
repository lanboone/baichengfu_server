package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.model.CustomOrderEntity;
import com.yihukurama.sysbase.model.OrderEntity;
import com.yihukurama.sysbase.model.OrderProductEntity;
import com.yihukurama.sysbase.model.StandardConfigEntity;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomOrderService extends CrudService<CustomOrderEntity> {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CustomOrderEntity create(CustomOrderEntity customOrderEntity) throws TipsException {
        //创建单号
        customOrderEntity.setNum(NumberUtil.getNum());
        return super.create(customOrderEntity);
    }

}
