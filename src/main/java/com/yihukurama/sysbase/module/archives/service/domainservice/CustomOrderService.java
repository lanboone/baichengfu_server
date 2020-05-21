package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.model.*;
import com.yihukurama.sysbase.module.archives.domain.CustomOrder;
import com.yihukurama.sysbase.module.archives.domain.Order;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomOrderService extends CrudService<CustomOrderEntity> {

    @Override
    public CustomOrderEntity create(CustomOrderEntity customOrderEntity) throws TipsException {
        //创建单号
        customOrderEntity.setNum(NumberUtil.getNum());
        return super.create(customOrderEntity);
    }


    @Autowired
    CustomStepService customStepService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CustomOrderEntity update(CustomOrderEntity customOrderEntity) throws TipsException {
        if(customOrderEntity instanceof CustomOrder){
            CustomOrder customOrder = (CustomOrder) customOrderEntity;
            List<CustomStepEntity> customStepEntities = customOrder.getCustomStepEntities();
            if(!CollectionUtils.isEmpty(customStepEntities)){
                //先清空原来的，再创建新的
                //删除原规格和规格明细
                CustomStepEntity customStepEntity = new CustomStepEntity();
                customStepEntity.setCustomOrderId(customOrderEntity.getId());
                List<CustomStepEntity> customStepEntityList =  customStepService.list(customStepEntity);
                for (int i = 0; i < customStepEntityList.size(); i++) {
                    customStepService.remove(customStepEntityList.get(i));
                }
                for (int i = 0; i < customStepEntities.size(); i++) {
                    customStepEntities.get(i).setCustomOrderId(customOrderEntity.getId());
                    customStepService.create(customStepEntities.get(i));
                }
            }
        }


        return super.update(customOrderEntity);
    }
}
