package com.wxf.job.flink;

import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.sink.KafkaSinkBuilder;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;

/**
 * 给kafka发消息： kafka-console-producer.sh --bootstrap-server 127.0.0.1:9092 --topic topic_two
 * flink读取kafka
 */
public class FlinkReadKafka {

    private static final String MY_BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    private static final String TOPIC1 = "topic_two";

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers(MY_BOOTSTRAP_SERVERS)
                .setTopics(Collections.singletonList(TOPIC1))
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
                .build();

        DataStreamSource<String> kafkaSource = env.fromSource(source, WatermarkStrategy.noWatermarks(), "kafkaSource");

        kafkaSource.printToErr();

        SingleOutputStreamOperator<String> map = kafkaSource
                .filter(StringUtils::isNotBlank)
                .map(s -> String.valueOf(Integer.parseInt(s) * 2));

        KafkaSink<String> sink = KafkaSink.<String>builder()
                .setBootstrapServers(MY_BOOTSTRAP_SERVERS)
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic("topic_one")
                        .setValueSerializationSchema(new SimpleStringSchema())
                        .build())
                .setDeliveryGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();

        map.print();

        map.sinkTo(sink);

        env.execute();
    }

}
