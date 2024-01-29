package com.wxf.dynamic.datasource.config.datasource.aspect;

import com.wxf.dynamic.datasource.config.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 数据源 Aspect
 *
 * @author Wxf
 * @since 2024-01-29 09:55:37
 **/
@Aspect
@Component
public class DynamicDatasourceAspect {

    // 切点
    @Pointcut("@annotation(com.wxf.dynamic.datasource.config.datasource.aspect.Ds)")
    public void dynamicDatasource() {

    }

    // 环绕
    @Around("dynamicDatasource()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // 类注解
            Class<?> clazz = joinPoint.getTarget().getClass();
            Ds clasDs = clazz.getAnnotation(Ds.class);

            // 方法注解
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Ds methodDs = methodSignature.getMethod().getAnnotation(Ds.class);
            if (Objects.nonNull(methodDs)) {
                // 方法上的数据源不为空则优先设置方法上的
                DynamicDataSourceContextHolder.setDatasource(methodDs.value());
            } else {
                DynamicDataSourceContextHolder.setDatasource(clasDs.value());
            }
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSource();
        }
    }
}
