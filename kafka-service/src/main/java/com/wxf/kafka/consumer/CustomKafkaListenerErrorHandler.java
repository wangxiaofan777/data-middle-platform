package com.wxf.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 自定义异常处理器
 *
 * @author Wxf
 * @since 2024-01-30 11:04:19
 **/
@Slf4j
@Component("customKafkaListenerErrorHandler")
public class CustomKafkaListenerErrorHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.error("custom kafka listener error", exception);
        return message;
    }
}
