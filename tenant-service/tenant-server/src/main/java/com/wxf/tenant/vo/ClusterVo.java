package com.wxf.tenant.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterVo implements Serializable {

    // 系统名称
    private String clusterName;

    // 系统编码
    private String clusterCode;

    // 备注
    private String remark;
}
