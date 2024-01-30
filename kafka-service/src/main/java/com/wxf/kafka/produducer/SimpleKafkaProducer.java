package com.wxf.kafka.produducer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * 简单kafka生产者
 *
 * @author Wxf
 * @since 2024-01-30 09:40:13
 **/
@Component
public class SimpleKafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMsg(String message) {
        this.kafkaTemplate.send("simple_tp_01", message);
    }

    /**
     * 带回调的消息发送
     *
     * @param message 消息
     */
    public void sendMsgOnCallback(String message) {
        // 发送消息
        this.kafkaTemplate.send("simple_tp_01", message);

        // 添加监听器，处理成功｜失败
        this.kafkaTemplate.setProducerListener(new ProducerListener<String, Object>() {
            @Override
            public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onError(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata, Exception exception) {
                System.out.println("消息发送失败");
            }
        });

    }
}
