package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserProductCommentEntity;
import lombok.Data;

@Data
public class AppuserProductComment extends AppuserProductCommentEntity {
    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;

}
