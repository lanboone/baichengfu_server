package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ConfigurationEntity;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 说明： Configuration的领域服务
 * @author: ouyk
 * @date: Created in 14:51 2018/6/19
 * @modified: by autor in 14:51 2018/6/19
 */
@Service
public class ConfigurationService extends CrudService<ConfigurationEntity> {


    public String doGetValueByCode(String code) throws TipsException {
        ConfigurationEntity loadOne = new ConfigurationEntity();
        loadOne.setCode(code);
        loadOne = loadOneByCondition(loadOne);
        if(loadOne != null){
            return loadOne.getValue();
        }else{
            return null;
        }
    }

}
