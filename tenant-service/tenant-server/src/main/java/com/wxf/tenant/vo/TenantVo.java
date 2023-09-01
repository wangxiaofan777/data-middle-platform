package com.wxf.tenant.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class TenantVo implements Serializable {

    // 租户名称
    @NotBlank(message = "租户名称不能为空")
    private String tenantName;

    // principal
    @NotBlank(message = "principal不能为空")
    private String principal;

    // keytab
    @NotBlank(message = "keytab不能为空")
    private String keytab;

    // 是否启用
    private Boolean enabled;

    // 备注
    private String remark;
}
