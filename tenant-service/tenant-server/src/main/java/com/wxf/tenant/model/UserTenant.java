package com.wxf.tenant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户租户映射表（一对多）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTenant implements Serializable {

    // 用户ID
    private Long userId;

    // 租户ID
    private Long tenantId;
}
