package com.yihukurama.sysbase.bean;

import com.yihukurama.sysbase.thirdparty.ali.easysdk.AliSdkInit;
import com.yihukurama.tkmybatisplus.app.component.FrameInit;

/**
 * 说明： 框架初始化，使用tkmybatis-plus
 * @author yihukurama
 * @date Created in 14:26 2020/1/27
 *       Modified by yihukurama in 14:26 2020/1/27
 */
public class AppFrame extends FrameInit {

    /**
     * 项目包路径
     */
    public static final String appPackage = "com.yihukurama.sysbase";
    /**
     * 项目Mapper包路径
     */
    public static final String mapperPackage = "com.yihukurama.sysbase.mapper.";
    public static void initAll() {
        init(mapperPackage);
    }


}
