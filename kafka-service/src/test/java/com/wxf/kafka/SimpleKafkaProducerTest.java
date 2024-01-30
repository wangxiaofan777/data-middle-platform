package com.wxf.kafka;

import com.wxf.kafka.produducer.SimpleKafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试
 *
 * @author Wxf
 * @since 2024-01-30 09:49:49
 **/
@SpringBootTest
public class SimpleKafkaProducerTest {
    @Autowired
    private SimpleKafkaProducer simpleKafkaProducer;


    @Test
    void sendMsg(){
        for (int i = 0; i < 1000; i++) {
            String msg = String.format("Hello World %s", i);
            this.simpleKafkaProducer.sendMsg(msg);
        }
    }

    @Test
    void sendMsgOnCallback(){
        for (int i = 0; i < 1000; i++) {
            String msg = String.format("Hello World %s", i);
            this.simpleKafkaProducer.sendMsgOnCallback(msg);
        }
    }
}
