package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserSampleEntity;
import com.yihukurama.sysbase.model.SampleRoomEntity;
import lombok.Data;

@Data
public class AppuserSample extends AppuserSampleEntity {

    /**
     * 关联的样板间
     */
    SampleRoomEntity sampleRoomEntity;
}
