package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.AppuserSampleEntity;
import com.yihukurama.sysbase.model.AppuserSampleEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import com.yihukurama.sysbase.module.archives.domain.AppuserSample;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AppuserSampleService extends CrudService<AppuserSampleEntity> {


    @Autowired
    SampleRoomService sampleRoomService;

    @Override
    public Result list(AppuserSampleEntity appuserSampleEntity, Integer page, Integer limit) throws TipsException {
        Result result = super.list(appuserSampleEntity, page, limit);
        if(appuserSampleEntity instanceof AppuserSample){
            AppuserSample appuserSample  = (AppuserSample) appuserSampleEntity;
            if(appuserSample.getSearchType() == AppuserSample.SEARCH_TYPE_10){
                return result;
            }
            List<AppuserSampleEntity> appuserSampleEntityList = (List<AppuserSampleEntity>) result.getData();
            List<AppuserSample> appuserSampleList = TransferUtils.transferEntityList2DomainList(appuserSampleEntityList,AppuserSample.class);
            if(!CollectionUtils.isEmpty(appuserSampleEntityList)){
                for (int i = 0; i < appuserSampleList.size(); i++) {
                    String proId = appuserSampleList.get(i).getSampleId();
                    SampleRoomEntity sampleRoomEntity = new SampleRoomEntity();
                    sampleRoomEntity.setId(proId);
                    sampleRoomEntity = sampleRoomService.load(sampleRoomEntity);
                    appuserSampleList.get(i).setSampleRoomEntity(sampleRoomEntity);
                }
            }
            result.setData(appuserSampleList);
        }
        return  result;
    }
}
