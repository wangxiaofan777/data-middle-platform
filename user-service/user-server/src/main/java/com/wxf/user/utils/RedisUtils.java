package com.wxf.user.utils;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.K;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundStreamOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author Wxf
 * @since 2023-10-20 16:45:46
 **/
@Slf4j
@Component
public class RedisUtils {

    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisUtils(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(Object key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(Object key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


    public Long leftPush(Object key, Object value) {
        return this.redisTemplate.opsForList().leftPush(key, value);
    }

    public Long rightPush(Object key, Object value) {
        return this.redisTemplate.opsForList().rightPush(key, value);
    }

    public Object leftPop(Object key) {
        return this.redisTemplate.opsForList().leftPop(key);
    }

    public List<Object> leftPop(Object key, long count) {
        return this.redisTemplate.opsForList().leftPop(key, count);
    }

    public Object leftPop(Object key, long timeout, TimeUnit timeUnit) {
        return this.redisTemplate.opsForList().leftPop(key, timeout, timeUnit);
    }

    public Object leftPop(Object key, Duration duration) {
        return this.redisTemplate.opsForList().leftPop(key, duration);
    }

    public Object rightPop(Object key) {
        return this.redisTemplate.opsForList().rightPop(key);
    }

    public List<Object> rightPop(Object key, long count) {
        return this.redisTemplate.opsForList().rightPop(key, count);
    }

    public Object rightPop(Object key, long timeout, TimeUnit timeUnit) {
        return this.redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
    }

    public Object rightPop(Object key, Duration duration) {
        return this.redisTemplate.opsForList().rightPop(key, duration);
    }

    public void push(Object key, Object hashKey, Object hashValue) {
        this.redisTemplate.opsForHash().put(key, hashKey, hashValue);
    }

    public Boolean hasKey(Object key) {
        return this.redisTemplate.hasKey(key);
    }

    public Set<Object> keys(Object key) {
        return this.redisTemplate.keys(key);
    }

    public Set<Object> hashKeys(Object key) {
        return this.redisTemplate.opsForHash().keys(key);
    }

    public Long increment(Object key, Object hashKey, long delta) {
        return this.redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    public Double increment(Object key, Object hashKey, double delta) {
        return this.redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    public Boolean hasKey(Object key, Object hashKey) {
        return this.redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public Object get(Object key, Object hashKey) {
        return this.redisTemplate.opsForHash().get(key, hashKey);
    }

    public Collection<? extends Object> multiGet(Object key, Collection<Object> hashKeys) {
        return this.redisTemplate.opsForHash().multiGet(key, hashKeys);
    }

    public Long delete(Object key, Object... hashKeys) {
        return this.redisTemplate.opsForHash().delete(key, hashKeys);
    }

    public Long add(Object key, Object... values) {
        return this.redisTemplate.opsForSet().add(key, values);
    }

    public Long remove(K key, Object... values) {
        return this.redisTemplate.opsForSet().remove(key, values);
    }

    public Object pop(Object key) {
        return this.redisTemplate.opsForSet().pop(key);
    }

    public List<Object> pop(Object key, long count) {
        return this.redisTemplate.opsForSet().pop(key, count);
    }

    public Boolean set(Object key, Object value, double score) {
        return this.redisTemplate.opsForZSet().add(key, value, score);
    }


    public Boolean expire(Object key, long timeout, TimeUnit timeUnit) {
        return this.redisTemplate.expire(key, timeout, timeUnit);
    }

    public Boolean expire(Object key, Duration duration) {
        return this.redisTemplate.expire(key, duration);
    }

    public Boolean expireAt(Object key, Date date) {
        return this.redisTemplate.expireAt(key, date);
    }


    public BoundValueOperations<Object, Object> boundValueOps(Object key) {
        return this.redisTemplate.boundValueOps(key);
    }

    public BoundListOperations<Object, Object> boundListOps(Object key) {
        return this.redisTemplate.boundListOps(key);
    }

    public BoundHashOperations<Object, Object, Object> boundHashOps(Object key) {
        return this.redisTemplate.boundHashOps(key);
    }

    public BoundSetOperations<Object, Object> boundSetOps(Object key) {
        return this.redisTemplate.boundSetOps(key);
    }

    public BoundZSetOperations<Object, Object> boundZSetOps(Object key) {
        return this.redisTemplate.boundZSetOps(key);
    }

    public BoundGeoOperations<Object, Object> boundGeoOps(Object key) {
        return this.redisTemplate.boundGeoOps(key);
    }

    public BoundStreamOperations<Object, Object, Object> boundStreamOps(Object key) {
        return this.redisTemplate.boundStreamOps(key);
    }

    /**
     * 执行脚本
     *
     * @param redisScript redis脚本
     * @param keys        keys值
     * @param args        参数
     * @return 返回值
     */
    public Object execute(RedisScript<Object> redisScript, List<Object> keys, Object... args) {
        return this.redisTemplate.execute(redisScript, keys, args);
    }

    public Boolean setBit(Object key, long offset, boolean value) {
        return this.redisTemplate.opsForValue().setBit(key, offset, value);
    }

    public Object getBit(Object key, long offset) {
        return this.redisTemplate.opsForValue().getBit(key, offset);
    }

    public Long bitCount(Object key) {
        return this.redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.bitPos(String.valueOf(key).getBytes(StandardCharsets.UTF_8), true);
            }
        });
    }
}
