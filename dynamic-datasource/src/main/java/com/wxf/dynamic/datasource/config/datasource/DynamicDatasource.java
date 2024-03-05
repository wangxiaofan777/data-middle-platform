package com.wxf.dynamic.datasource.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态数据源路由
 *
 * @author Wxf
 * @since 2024-01-20 14:50:15
 **/
public class DynamicDatasource extends AbstractRoutingDataSource {

    public static final Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>(16);

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }

}
