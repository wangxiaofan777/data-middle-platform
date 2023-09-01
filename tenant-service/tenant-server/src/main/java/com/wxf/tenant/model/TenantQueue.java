package com.wxf.tenant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 租户队列映射关系（一对多）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantQueue implements Serializable {

    // 租户ID
    private Long tenantId;

    // 队列
    private String queue;
}
