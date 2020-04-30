package com.yihukurama.sysbase.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 说明： 系统的相关配置
 * @author yihukurama
 * @date Created in 14:26 2020/1/27
 *       Modified by yihukurama in 14:26 2020/1/27
 */
@ConfigurationProperties(prefix = "sysconfig")
@Configuration
@Getter
@Setter
public class SysConfig {


    /**
     * 文件路径地址，图片，视频，音频等
     */
    private String urlStaticPic;

    /**
     * 访问日志存储地址
     */
    private String accesslog;

    /**
     * redis前缀，为区分不同项目
     */
    private String redisPrefix;

}
