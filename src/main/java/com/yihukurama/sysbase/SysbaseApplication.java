package com.yihukurama.sysbase;

import com.yihukurama.sysbase.bean.AppFrame;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.yihukurama.sysbase.mapper"})
@ComponentScan(basePackages = {"com.yihukurama"})
@EnableSwagger2
@EnableFeignClients
public class SysbaseApplication {

    public static void main(String[] args) {
        AppFrame.initAll();
        ApplicationContext context = SpringApplication.run(SysbaseApplication.class, args);
        SpringBeanTools.setApplicationContext1(context);
    }

}
