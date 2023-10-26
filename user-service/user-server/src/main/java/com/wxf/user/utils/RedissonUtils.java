package com.wxf.user.utils;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RHyperLogLog;
import org.redisson.api.RKeys;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Redisson工具栏类
 *
 * @author Wxf
 * @since 2023-10-23 20:35:58
 **/
@Component
public class RedissonUtils {

    private final RedissonClient redissonClient;

    public RedissonUtils(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 加锁
     * 默认30秒超时
     *
     * @param key key值
     * @return 锁
     */
    public RLock getLock(String key) {
        return this.redissonClient.getLock(key);
    }





    /**
     * 解锁
     *
     * @param key key值
     */
    public void unlock(String key) {
        this.redissonClient.getLock(key).unlock();
    }

    /**
     * 读写锁
     *
     * @param key key值
     * @return 读写锁
     */
    public ReadWriteLock getReadWriteLock(String key) {
        return this.redissonClient.getReadWriteLock(key);
    }

    /**
     * 获取读锁
     *
     * @param key key值
     * @return 读锁
     */
    public Lock getReadLock(String key) {
        return this.getReadWriteLock(key).readLock();
    }

    /**
     * 获取写锁
     *
     * @param key key值
     * @return 写锁
     */
    public Lock getWriteLock(String key) {
        return this.getReadWriteLock(key).readLock();
    }

    public RBloomFilter<Object> getBloomFilter(String key) {
        return this.redissonClient.getBloomFilter(key);
    }

    public RHyperLogLog<Object> getHyperLogLogs(String key) {
        return this.redissonClient.getHyperLogLog(key);
    }

    /**
     * 获取全部Key
     *
     * @return 全部Key
     */
    public RKeys getKeys() {
        return this.redissonClient.getKeys();
    }

}
