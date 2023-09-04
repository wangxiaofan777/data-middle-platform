package com.wxf.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxf.commons.enums.BaseEntity;
import com.wxf.tenant.vo.ClusterVo;
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
public class Cluster extends BaseEntity implements Serializable {

    // ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 系统名称
    private String clusterName;

    // 系统编码
    private String clusterCode;

    // 是否启用
    private Boolean enabled;

    // 备注
    private String remark;


    public static Cluster of(ClusterVo clusterVo) {
        return Cluster.builder()
                .clusterCode(clusterVo.getClusterCode())
                .clusterName(clusterVo.getClusterName())
                .remark(clusterVo.getRemark())
                .build();
    }
}
