package com.wxf.tenant.locks;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisLock implements ILock {

    private static final String LOCK_PREFIX = "LOCK_";

    private final String key;
    private final StringRedisTemplate stringRedisTemplate;

    public RedisLock(String key, StringRedisTemplate stringRedisTemplate) {
        this.key = key;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean tryLock(long timeOutSec) {
        String threadId = this.getThreadId();
        String lockKey = this.getLockKey();
        Boolean locked = this.stringRedisTemplate.opsForValue()
                .setIfAbsent(lockKey, threadId, timeOutSec, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(locked);
    }

    @Override
    public void unlock() {
        String threadId = this.getThreadId();
        String lockKey = this.getLockKey();
        String value = this.stringRedisTemplate.opsForValue().get(lockKey);

        // 比较两把锁是否一致，防止出现分布式锁误删(非原子性，锁超时仍可能会出现分布式锁误删)
        if (threadId.equals(value)) {
            this.stringRedisTemplate.delete(lockKey);
        }
    }

    /**
     * 获取当前线程ID
     *
     * @return 线程ID
     */
    private String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }

    /**
     * 获取分布式锁Key
     *
     * @return 分布式锁Key
     */
    private String getLockKey() {
        return LOCK_PREFIX + key;
    }
}
