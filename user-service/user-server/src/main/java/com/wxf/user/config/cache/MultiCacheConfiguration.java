package com.wxf.user.config.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.Collection;

/**
 * @author wxf
 * @since 2023-10-19 16:25
 **/
public class MultiCacheConfiguration implements CacheResolver {

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        return null;
    }
}
