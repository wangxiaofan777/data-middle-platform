package com.wxf.job.job;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 任务配置
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/29 15:43:15
 */
@Data
@Configuration
@ConditionalOnProperty(name = "job.enabled", havingValue = "true")
@ConfigurationProperties(prefix = "job")
public class JobConfiguration {
}
