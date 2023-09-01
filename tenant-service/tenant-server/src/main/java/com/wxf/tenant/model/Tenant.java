package com.wxf.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxf.commons.enums.BaseEntity;
import com.wxf.tenant.vo.TenantVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 租户
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Tenant extends BaseEntity implements Serializable {

    // ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 租户名称
    private String tenantName;

    // principal
    private String principal;

    // keytab
    private String keytab;

    // 是否启用
    private Boolean enabled;

    // 备注
    private String remark;

    public static Tenant of(TenantVo tenantVo) {
        return Tenant.builder()
                .tenantName(tenantVo.getTenantName())
                .principal(tenantVo.getPrincipal())
                .keytab(tenantVo.getKeytab())
                .remark(tenantVo.getRemark())
                .build();
    }

    public static void of(Tenant tenant, TenantVo tenantVo) {
        tenant.setTenantName(tenantVo.getTenantName());
        tenant.setPrincipal(tenantVo.getPrincipal());
        tenant.setKeytab(tenantVo.getKeytab());
        tenant.setRemark(tenantVo.getRemark());
    }
}
