package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserCommentEntity;
import lombok.Data;

@Data
public class AppuserComment extends AppuserCommentEntity {
    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;

}
