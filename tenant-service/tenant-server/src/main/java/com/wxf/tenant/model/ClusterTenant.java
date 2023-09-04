package com.wxf.tenant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统租户映射关系表（一对多）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterTenant implements Serializable {


    // 系统ID
    private Long systemId;

    // 租户ID
    private Long tenantId;

}
