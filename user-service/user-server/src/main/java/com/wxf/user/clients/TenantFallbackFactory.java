package com.wxf.user.clients;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 租户降级
 *
 * @author Wxf
 * @since 2023-11-09 15:50:47
 **/
@Component
public class TenantFallbackFactory implements FallbackFactory<TenantClient> {

    @Override
    public TenantClient create(Throwable cause) {
        return new TenantClient() {
            @Override
            public Map<String, Object> getTenantById(Long id) {
                return null;
            }
        };
    }
}
