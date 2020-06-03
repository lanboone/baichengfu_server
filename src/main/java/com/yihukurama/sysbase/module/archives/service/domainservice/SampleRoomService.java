package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.ProductMapper;
import com.yihukurama.sysbase.mapper.SampleProductMapper;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.model.SampleProductEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import com.yihukurama.sysbase.module.archives.domain.SampleRoom;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 说明： 样板间服务类
 *
 * @author yihukurama
 * @date Created in 11:06 2020/4/11
 * Modified by yihukurama in 11:06 2020/4/11
 */
@Service
public class SampleRoomService extends CrudService<SampleRoomEntity> {

    @Autowired
    SampleProductMapper sampleProductMapper;

    /**
     * 说明： 重写样板间创建方法，增加商品链接的关联
     *
     * @author yihukurama
     * @date Created in 11:07 2020/4/11
     * Modified by yihukurama in 11:07 2020/4/11
     */
    @Override
    @Transient
    public SampleRoomEntity create(SampleRoomEntity sampleRoomEntity) throws TipsException {
        SampleRoomEntity newSampleRoom = super.create(sampleRoomEntity);
        if (sampleRoomEntity instanceof SampleRoom) {
            SampleRoom sampleRoom = (SampleRoom) sampleRoomEntity;
            List<ProductEntity> productEntityList = sampleRoom.getProductEntityList();
            String sId = newSampleRoom.getId();
            if (!EmptyUtil.isEmpty(productEntityList)) {
                for (ProductEntity product : productEntityList
                ) {
                    //创建关联关系
                    String pId = product.getId();
                    SampleProductEntity sampleProductEntity = new SampleProductEntity();
                    sampleProductEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    sampleProductEntity.setProductId(pId);
                    sampleProductEntity.setSampleId(sId);
                    sampleProductMapper.insert(sampleProductEntity);
                }
            }

            sampleRoom.setId(sId);
            return sampleRoom;
        } else {
            return newSampleRoom;
        }


    }

    @Override
    @Transient
    public SampleRoomEntity update(SampleRoomEntity sampleRoomEntity) throws TipsException {
        SampleRoomEntity newSampleRoom = super.update(sampleRoomEntity);
        if (sampleRoomEntity instanceof SampleRoom) {
            SampleRoom sampleRoom = (SampleRoom) sampleRoomEntity;
            List<ProductEntity> productEntityList = sampleRoom.getProductEntityList();
            String sId = newSampleRoom.getId();
            if (!EmptyUtil.isEmpty(productEntityList)) {
                //删除原关联关系
                SampleProductEntity oldSampleProductEntity = new SampleProductEntity();
                oldSampleProductEntity.setSampleId(sampleRoomEntity.getId());
                List<SampleProductEntity> sampleProductEntityList = sampleProductMapper.select(oldSampleProductEntity);
                for (int i = 0; i < sampleProductEntityList.size(); i++) {
                    sampleProductMapper.delete(sampleProductEntityList.get(i));
                }
                //创建新的关联关系
                for (ProductEntity product : productEntityList
                ) {
                    //创建关联关系
                    String pId = product.getId();
                    SampleProductEntity sampleProductEntity = new SampleProductEntity();
                    sampleProductEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    sampleProductEntity.setProductId(pId);
                    sampleProductEntity.setSampleId(sId);
                    sampleProductMapper.insert(sampleProductEntity);
                }
            }

            sampleRoom.setId(sId);
            return sampleRoom;
        } else {
            return newSampleRoom;
        }


    }

    @Autowired
    ProductMapper productMapper;

    @Override
    @Transient
    public SampleRoomEntity load(SampleRoomEntity sampleRoomEntity) throws TipsException {
        SampleRoomEntity loadSampleRoom = super.load(sampleRoomEntity);
        if(loadSampleRoom == null){
            throw new TipsException("无法加载此样板间");
        }
        if (sampleRoomEntity instanceof SampleRoom) {
            String sId = sampleRoomEntity.getId();
            SampleProductEntity sampleProductEntity = new SampleProductEntity();
            sampleProductEntity.setSampleId(sId);
            List<SampleProductEntity> sampleProductEntityList = sampleProductMapper.select(sampleProductEntity);
            List<ProductEntity> productEntityList = new ArrayList<>();
            for (SampleProductEntity sp : sampleProductEntityList) {
                ProductEntity productEntity = productMapper.selectByPrimaryKey(sp.getProductId());
                productEntityList.add(productEntity);
            }
            SampleRoom sampleRoom = TransferUtils.transferEntity2Domain(loadSampleRoom, SampleRoom.class);
            sampleRoom.setProductEntityList(productEntityList);
            return sampleRoom;
        } else {
            return loadSampleRoom;
        }


    }


    @Override
    public Result list(SampleRoomEntity sampleRoomEntity, Integer page, Integer limit) throws TipsException {
        if (sampleRoomEntity instanceof SampleRoom) {
            SampleRoom listSample = (SampleRoom) sampleRoomEntity;
            Integer searchType = listSample.getSearchType();
            if (searchType == null) {
                //默认时间倒叙不处理
            } else if (searchType == 10) {
                //权重排序
                sampleRoomEntity.setSortSql("order_count desc");
            } else if (searchType == 20) {
                //浏览数排序
                sampleRoomEntity.setSortSql("s_favorite_number desc");
            }

            return super.list(sampleRoomEntity, page, limit);

        }


        return super.list(sampleRoomEntity, page, limit);
    }
}
