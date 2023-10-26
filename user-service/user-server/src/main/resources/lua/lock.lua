-- 不存在该key时
if (redis.call('exists', KEYS[1]) == 0) then
    -- 新增该锁并且hash中该线程id对应的count置1
    redis.call('hincrby', KEYS[1], ARGV[2], 1);
    -- 设置过期时间
    redis.call('pexpire', KEYS[1], ARGV[1]);
    return nil;
end;

-- 存在该key 并且 hash中线程id的key也存在
if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then
    -- 线程重入次数++
    redis.call('hincrby', KEYS[1], ARGV[2], 1);
    redis.call('pexpire', KEYS[1], ARGV[1]);
    return nil;
end;
return redis.call('pttl', KEYS[1]);