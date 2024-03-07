package com.wxf.dynamic.datasource;

import com.wxf.dynamic.datasource.config.SpringApplicationContext;
import com.wxf.dynamic.datasource.config.datasource.DynamicDatasource;
import com.wxf.dynamic.datasource.service.impl.UserServiceImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

/**
 * 数据源测试
 *
 * @author Wxf
 * @since 2024-01-20 14:42:28
 **/
@ActiveProfiles("dev")
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        System.out.println(this.userService.getUserList());
    }

    @Test
    void getUserListByDs1() {
        System.out.println(this.userService.getUserListByDs1());
    }

    @Test
    void getUserListByDs2() {
        System.out.println(this.userService.getUserListByDs2());
    }


    @Test
    public void dynamic() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/ds3?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true&useIPv6=false");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        DynamicDatasource.dataSourceMap.put("ds3", hikariDataSource);

        DynamicDatasource dynamicDatasource = SpringApplicationContext.getBean(DynamicDatasource.class);
        dynamicDatasource.afterPropertiesSet();

        System.out.println(this.userService.getDynamicUserList());
    }
}
