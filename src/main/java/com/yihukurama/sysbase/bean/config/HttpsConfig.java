package com.yihukurama.sysbase.bean.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明： springboot的http配置，在使用https时同时使用http
 * @author yihukurama
 * @date Created in 14:25 2020/1/27
 *       Modified by yihukurama in 14:25 2020/1/27
 */
@Configuration
public class HttpsConfig {

    @Value("${server.http.port}")
    private Integer port;

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        // 添加http
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    /**
     * 说明：配置http
     *
     * @author dengshuai
     * @date Created in 14:56 2019/2/26
     * @modified by autor in 14:56 2019/2/26
     */
    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(port);
        return connector;
    }
}
