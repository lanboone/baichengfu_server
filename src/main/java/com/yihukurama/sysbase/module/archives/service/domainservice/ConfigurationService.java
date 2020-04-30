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

    @Override
    public ConfigurationEntity create(ConfigurationEntity configurationEntity) throws TipsException {
        return null;
    }

    @Override
    public int creates(List<ConfigurationEntity> list) throws TipsException {
        return 0;
    }

    @Override
    public int removes(ConfigurationEntity configurationEntity) throws TipsException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return 0;
    }

    @Override
    public int remove(ConfigurationEntity configurationEntity) throws TipsException {
        return 0;
    }
}
