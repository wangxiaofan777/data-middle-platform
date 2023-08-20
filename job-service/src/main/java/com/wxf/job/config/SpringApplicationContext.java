package com.wxf.job.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 获取Spring上下文容器
 *
 * @author WangXiaofan777
 * @since  2021/9/13 14:25
 * @version 1.0.0
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringApplicationContext.applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static void publishEvent(ApplicationEvent event) {
        getApplicationContext().publishEvent(event);
    }

    public static void publishEvent(Object event) {
        getApplicationContext().publishEvent(event);
    }

}
