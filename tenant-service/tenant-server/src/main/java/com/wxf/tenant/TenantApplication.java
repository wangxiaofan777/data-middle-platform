package com.wxf.tenant;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 租户管理服务入口
 *
 * @author WangXiaofan777
 * @since 2023-7-20 10:42:47
 */
@EnableDubbo
@SpringBootApplication(
        scanBasePackages = {
                "com.wxf.tenant",
                "com.wxf.user.provider"
        }
)
public class TenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantApplication.class, args);
    }
}
