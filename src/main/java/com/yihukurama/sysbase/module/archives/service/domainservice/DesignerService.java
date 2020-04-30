package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.model.AppuserEntity;
import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.sysbase.module.archives.domain.Designer;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明： Designer的领域服务
 *
 * @author: yihukurama
 * @date: Created in 11:37 2018/4/2
 * @modified: by yihukurama in 11:37 2018/4/2
 */
@Service
public class DesignerService extends CrudService<DesignerEntity> {

    @Autowired
    AppuserMapper appuserMapper;

    @Autowired
    DesignerMapper designerMapper;
    @Override
    public Result list(DesignerEntity designerEntity, Integer page, Integer limit) throws TipsException {
        if(designerEntity instanceof Designer){
            Designer designer = (Designer) designerEntity;
            if(!EmptyUtil.isEmpty(designer.getKeyWords())){
                //关键字查询
                PageHelper.startPage(page, limit);

                List<DesignerEntity> designers = designerMapper.selectByKeyWords(designer);
                PageInfo<DesignerEntity> pageInfo = new PageInfo(designers);
                return Result.listSuccessed(designers, pageInfo.getTotal());
            }
        }

        Result result = super.list(designerEntity, page, limit);
        List<DesignerEntity> designerEntities = (List<DesignerEntity>) result.getData();
        List<Designer> designers = new ArrayList<>();
        if (!CollectionUtils.isEmpty(designerEntities)) {
            designerEntities.forEach(designerEntityFromDb -> {
                Designer designer = new Designer();
                BeanUtils.copyProperties(designerEntityFromDb, designer);
                String userId = designerEntity.getUserId();
                // 查找对应的用户信息
                AppuserEntity appuserEntity = new AppuserEntity();
                appuserEntity.setId(userId);
                List<AppuserEntity> appuserEntityList = appuserMapper.select(appuserEntity);
                if (CollectionUtils.isEmpty(appuserEntityList)) {
                    LogUtil.errorLog(designerEntityFromDb, "this Designer does not have a right userId:  " + userId);
                } else {
                    AppuserEntity appuserEntityFromDb = appuserEntityList.get(0);
                    designer.setAppUserName(appuserEntityFromDb.getUserName());
                    designer.setAppUserPhone(appuserEntityFromDb.getPhoneNumber());
                }
                designers.add(designer);
            });
            result.setData(designers);
            return result;
        } else {
            return result;
        }
    }

}
