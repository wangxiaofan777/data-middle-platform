package com.wxf.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 简单kafka消费者
 *
 * @author Wxf
 * @since 2024-01-30 09:43:27
 **/
@Component
public class SimpleKafkaConsumer {

    @KafkaListener(topics = "simple_tp_01", groupId = "simple_grp_01" , errorHandler = "customKafkaListenerErrorHandler")
    public void onMessage(ConsumerRecord<String, Object> consumerRecord) {
        System.out.println(consumerRecord);
    }
}
