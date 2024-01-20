package com.wxf.dynamic.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 动态数据源服务
 *
 * @author wxf
 */
@SpringBootApplication(scanBasePackages = "com.wxf.dynamic.datasource")
public class DynamicDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }
}
