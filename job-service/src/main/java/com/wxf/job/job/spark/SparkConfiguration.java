package com.wxf.job.job.spark;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Spark配置
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/26 14:18:17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spark")
public class SparkConfiguration {

    // SPARK_HOME环境变量
    private String sparkHome;

    // JAVA_HOME环境变量
    private String javaHome;

    // 是否输出更多日志
    private Boolean verbose;

    // 默认config
    private Map<String, String> config;
}
