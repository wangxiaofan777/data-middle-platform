package com.wxf.user.config.log;

import com.wxf.commons.enums.ModuleName;
import com.wxf.commons.enums.ServiceName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Log注解
 *
 * @author Wxf
 * @since 2023-10-19 20:00:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

    // 服务名
    ServiceName serviceName();

    // 模块名
    ModuleName moduleName();

}
