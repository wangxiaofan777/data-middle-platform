package com.wxf.kafka.produducer;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Kafka 生产者
 *
 * @author Wxf
 * @since 2024-01-29 16:39:48
 **/
public class KafkaProducerTest {

    public static void main(String[] args) {
        final Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configs.put(ProducerConfig.ACKS_CONFIG, "all");

        Producer<String, Object> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(configs);

        for (int i = 0; i < 100; i++) {
            String msg = String.format("%s %s", "hello world", i);
            ProducerRecord<String, Object> producerRecord = new ProducerRecord<String, Object>("test_tp_01", msg);

            producer.send(producerRecord);
        }

        producer.close(Duration.ofMinutes(1));

    }
}
