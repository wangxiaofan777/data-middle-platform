package com.wxf.user;

import com.wxf.user.utils.RedisUtils;
import com.wxf.user.utils.RedissonUtils;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RHyperLogLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wxf
 * @since 2023-10-21 10:21:58
 **/
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedissonUtils redissonUtils;

    @Test
    void set() {
        this.redisUtils.set("k1", "v1");
    }


    @Test
    void setBit() {
        for (int i = 0; i < 10; i++) {
            this.redisUtils.setBit("key", i, true);
        }
    }

    @Test
    void getBit() {
        System.out.println(this.redisUtils.getBit("b1", 1));
        System.out.println(this.redisUtils.bitCount("b1"));
    }


    @Test
    void getKeys() {
        Iterable<String> keys = this.redissonUtils.getKeys().getKeys();
        for (String s : keys) {
            System.out.println(s);
        }
    }

    @Test
    void logTest() {
        RHyperLogLog<Object> hyperLogLog = this.redissonUtils.getHyperLogLogs("log1");
        for (int i = 0; i < 10; i++) {
            hyperLogLog.add(i);
        }

        System.out.println(hyperLogLog.count());

        RHyperLogLog<Object> hyperLogLog2 = this.redissonUtils.getHyperLogLogs("log2");
        for (int i = 0; i < 1000; i++) {
            hyperLogLog2.add(i);
        }

        System.out.println(hyperLogLog2.count());

        hyperLogLog.mergeWith(hyperLogLog2.getName());
        System.out.println(hyperLogLog.count());

    }

    @Test
    void getBloomFilter() {
        RBloomFilter<Object> bloomFilter = this.redissonUtils.getBloomFilter("test_bool");

        bloomFilter.tryInit(10000, 0.001);

        List<Integer> list = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        bloomFilter.add(list);

        System.out.println(bloomFilter.getSize());
        System.out.println(bloomFilter.count());

//        bloomFilter.deleteAsync();
    }
}
