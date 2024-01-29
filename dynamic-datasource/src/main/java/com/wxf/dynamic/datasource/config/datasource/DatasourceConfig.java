package com.wxf.dynamic.datasource.config.datasource;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 *
 * @author Wxf
 * @since 2024-01-27 10:39:58
 **/
@Configuration
public class DatasourceConfig {


    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dynamicDatasource") DynamicDatasource dynamicDatasource) {
        return new JdbcTemplate(dynamicDatasource);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource ds1() {
        return DataSourceBuilder.create().build();
    }

    @Bean("ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource ds2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DynamicDatasource dynamicDatasource(@Qualifier("dataSource") DataSource dataSource,
                                               @Qualifier("ds1") DataSource d1,
                                               @Qualifier("ds2") DataSource d2) {
        DynamicDatasource dynamicDatasource = new DynamicDatasource();

        // 设置默认数据源
        dynamicDatasource.setDefaultTargetDataSource(dataSource);

        // 保存所有可切换的数据源
        Map<Object, Object> dataSourceMap = new HashMap<>(16);
        dataSourceMap.put("dataSource", dataSource);
        dataSourceMap.put("ds1", d1);
        dataSourceMap.put("ds2", d2);

        dynamicDatasource.setTargetDataSources(dataSourceMap);

        return dynamicDatasource;
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("dynamicDatasource") DynamicDatasource dynamicDatasource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDatasource);
//        sqlSessionFactoryBean.setMapperLocations();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(@Qualifier("dynamicDatasource") DynamicDatasource dynamicDatasource) {
        return new DataSourceTransactionManager(dynamicDatasource);
    }
}
