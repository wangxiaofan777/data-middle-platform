package com.wxf.dynamic.datasource;

import org.junit.jupiter.api.Test;
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

    @Test
    void create() {
        DataSource dataSource = DataSourceBuilder.create().build();
    }
}
