package com.wxf.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxf.commons.enums.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
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

    // 备注
    private String remark;
}
