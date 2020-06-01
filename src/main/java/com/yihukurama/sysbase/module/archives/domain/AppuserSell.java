package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.AppuserSellEntity;
import com.yihukurama.tkmybatisplus.app.annotation.SqlWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class AppuserSell extends AppuserSellEntity {

    /**
     * 纯粹搜索数据库关联id
     */
    public static final int SEARCH_TYPE_10 = 10;
    /**
     * 为10 时 纯粹搜索数据库关联id
     */
    int searchType;


    /**
     * 查询时 大于等于该时间
     */
    @ApiModelProperty(value = "查询时 大于等于该时间")
    private Date gtCreateDate;
    /**
     * 查询时 小于等于该时间
     */
    @ApiModelProperty(value = "查询时 小于等于该时间")
    private Date ltCreateDate;
    @SqlWhere(value = SqlWhere.SqlWhereValue.GT,proprtityName = "create_date")
    public Date getGtCreateDate() {
        return gtCreateDate;
    }
    @SqlWhere(value = SqlWhere.SqlWhereValue.LT,proprtityName = "create_date")
    public Date getLtCreateDate() {
        return ltCreateDate;
    }


}
