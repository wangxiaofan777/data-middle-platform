package com.wxf.user.config.log;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.Objects;

/**
 * 日志切面
 *
 * @author wxf
 * @since 2023-10-19 20:04
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {

    //  切点
    @Pointcut("@annotation(com.wxf.user.config.log.Log)")
    public void pointcut() {
    }

    /**
     * 切面
     *
     * @param point 切点
     * @return 返回对象
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;

        Stopwatch stopwatch = Stopwatch.createStarted();

        try {
            if (log.isDebugEnabled()) {
                log.debug("================= Method proceed started....");
            }

            result = point.proceed();

            if (log.isDebugEnabled()) {
                log.debug("================= Method proceed successfully....");
            }
        } catch (Throwable e) {
            log.error("log around proceed error!", e);
        }

        Duration elapsed = stopwatch.elapsed();
        if (log.isDebugEnabled()) {
            log.debug("================= Method proceed cost time: {}", elapsed.getSeconds());
        }

        return result;
    }


    /**
     * 解析日志
     *
     * @param point 切点
     */
    private void getLogger(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point;
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        if (Objects.nonNull(annotation)) {
            annotation.moduleName();
        }
        // 类名
        String name = point.getTarget().getClass().getName();

        // 方法名
        String methodName = method.getName();

        // 参数
        String args = Arrays.toString(point.getArgs());


    }
}
