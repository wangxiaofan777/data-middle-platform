package com.wxf.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * 租户客户端
 *
 * @author Wxf
 * @since 2023-11-08 17:27:12
 **/
@FeignClient(url = "/tenant", fallbackFactory = TenantFallbackFactory.class)
public interface TenantClient {

    /**
     * 根据ID查询租户信息
     *
     * @param id 租户ID
     * @return 租户信息
     */
    @GetMapping("/tenant/{id}")
    Map<String, Object> getTenantById(@PathVariable("id") Long id);
}
