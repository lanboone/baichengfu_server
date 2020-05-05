package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.mapper.AppuserMapper;
import com.yihukurama.sysbase.mapper.DesignerMapper;
import com.yihukurama.sysbase.model.DesignerEntity;
import com.yihukurama.sysbase.module.archives.domain.Designer;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (designerEntity instanceof Designer) {
            Designer designer = (Designer) designerEntity;
            Integer searchType = designer.getSearchType();
            if (searchType == null) {
                //默认时间倒叙不处理
            } else if (searchType == 10) {
                //权重排序
                designerEntity.setSortSql("order_count,create_date desc");
            } else if (searchType == 20) {
                //浏览数排序
                designerEntity.setSortSql("likecount,create_date desc");
            }

            String searchStyles = designer.getSearchStyles();
            String whereSql = "";
            if (!EmptyUtil.isEmpty(designer.getKeyWords())) {
                whereSql = "(nick_name like '%s' or style like '%s')";
                whereSql = String.format(whereSql, designer.getKeyWords(), "%" + designer.getKeyWords() + "%");
                designer.setWhereSql(whereSql);
            }
            if (!EmptyUtil.isEmpty(searchStyles)) {
                String styles[] = searchStyles.split(";");
                for (int i = 0; i < styles.length; i++) {
                    if (!EmptyUtil.isEmpty(whereSql)) {
                        whereSql = whereSql + " or style like '%" + styles[i] + "%'";
                    } else {
                        whereSql = "style like '%" + styles[i] + "%'";
                    }
                }
            }

            designer.setWhereSql(whereSql);
        }


        return super.list(designerEntity, page, limit);
    }
}

