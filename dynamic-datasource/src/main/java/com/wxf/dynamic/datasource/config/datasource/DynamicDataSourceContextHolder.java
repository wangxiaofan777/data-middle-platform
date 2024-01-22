package com.wxf.dynamic.datasource.config.datasource;

import jakarta.annotation.Nullable;

/**
 * 数据源Holder
 *
 * @author Wxf
 * @since 2024-01-20 14:52:05
 **/
public class DynamicDataSourceContextHolder {

    /**
     * 通过ThreadLocal保存数据源
     */
    private static final ThreadLocal<String> DATASOURCE_THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 设置数据源
     *
     * @param datasource 数据源
     */
    public static void setDatasource(@Nullable String datasource) {
        DATASOURCE_THREAD_LOCAL.set(datasource);
    }

    /**
     * 获取数据源
     *
     * @return 数据源
     */
    public static String getDataSource() {
        return DATASOURCE_THREAD_LOCAL.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        DATASOURCE_THREAD_LOCAL.remove();
    }

}
