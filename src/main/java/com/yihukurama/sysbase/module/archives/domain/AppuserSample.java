package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserSampleEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import lombok.Data;

@Data
public class AppuserSample extends AppuserSampleEntity {

    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;

    /**
     * 关联的样板间
     */
    SampleRoomEntity sampleRoomEntity;
}
