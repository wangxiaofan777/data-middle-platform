package com.wxf.tenant.model;

import com.wxf.commons.enums.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TenantUser extends BaseEntity implements Serializable {

    // 租户ID
    private Long tenantId;

    // 用户ID
    private Long userId;
}
