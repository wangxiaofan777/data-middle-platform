package com.wxf.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Kafka 消费者测试
 *
 * @author Wxf
 * @since 2024-01-29 16:54:19
 **/
public class KafkaConsumerTest {

    public static void main(String[] args) {
        final Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "tp_grp_01");
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, Object> kafkaConsumer = new KafkaConsumer<>(configs);

        kafkaConsumer.subscribe(Collections.singleton("test_tp_01"));

        ConsumerRecords<String, Object> records = kafkaConsumer.poll(1_000);

        records.forEach(System.out::println);

        kafkaConsumer.close();
    }
}
