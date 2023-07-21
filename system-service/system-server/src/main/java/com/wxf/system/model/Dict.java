package com.wxf.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Dict extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String dictName;

    private String dictCode;

    private String parentId;

    private Integer level;

    private Integer sort;

    private Boolean enabled;
}
