package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.MasterMapper;
import com.yihukurama.sysbase.model.MasterEntity;
import com.yihukurama.sysbase.model.MasterEntity;
import com.yihukurama.sysbase.module.archives.domain.Master;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService extends CrudService<MasterEntity>{
    @Autowired
    AppuserMapper appuserMapper;

    @Autowired
    MasterMapper masterMapper;

    @Override
    public Result list(MasterEntity masterEntity, Integer page, Integer limit) throws TipsException {
        if (masterEntity instanceof Master) {
            Master master = (Master) masterEntity;
            Integer searchType = master.getSearchType();
            if (searchType == null) {
                //默认时间倒叙不处理
            } else if (searchType == 10) {
                //权重排序
                masterEntity.setSortSql("order_count,create_date desc");
            } else if (searchType == 20) {
                //浏览数排序
                masterEntity.setSortSql("likecount,create_date desc");
            }

            String searchSkills = master.getSearchSkills();
            String whereSql = "";
            if (!EmptyUtil.isEmpty(master.getKeyWords())) {
                whereSql = "(nick_name like '%s' or style like '%s')";
                whereSql = String.format(whereSql, "%"+master.getKeyWords()+"%", "%" + master.getKeyWords() + "%");
                master.setWhereSql(whereSql);
            }
            if (!EmptyUtil.isEmpty(searchSkills)) {
                String styles[] = searchSkills.split(";");
                for (int i = 0; i < styles.length; i++) {
                    if (!EmptyUtil.isEmpty(whereSql)) {
                        whereSql = whereSql + " or style like '%" + styles[i] + "%'";
                    } else {
                        whereSql = "style like '%" + styles[i] + "%'";
                    }
                }
            }

            master.setWhereSql(whereSql);
        }


        return super.list(masterEntity, page, limit);
    }


}
