package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ManagerprivilegeEntity;
import lombok.Data;

import java.util.List;

@Data
public class ManagerPrivilege extends ManagerprivilegeEntity {

    List<ManagerprivilegeEntity> managerprivilegeEntities;


}
