package com.yihukurama.sysbase.bean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 说明： 该项目的系统配置
 * @author yihukurama
 * @date Created in 10:38 2020/4/4
 *       Modified by yihukurama in 10:38 2020/4/4
 */
@Component
@Data
@ConfigurationProperties(prefix ="system")
public class SystemConfig {

    /**
     * 保存的图片路径
     */
    String saveFilePath;
}
