package com.wxf.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {
        "com.wxf.datasource.mapper"
})
@SpringBootApplication(scanBasePackages = {
        "com.wxf.datasource"
})
public class DatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceApplication.class, args);
    }

}
