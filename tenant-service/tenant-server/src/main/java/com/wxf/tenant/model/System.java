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
public class System extends BaseEntity implements Serializable {

    // ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 系统名称
    private String systemName;

    // 系统编码
    private String systemCode;

    // 是否启用
    private Boolean enabled;

    // 备注
    private String remark;
}
