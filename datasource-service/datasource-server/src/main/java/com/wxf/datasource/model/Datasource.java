package com.wxf.datasource.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxf.commons.enums.BaseEntity;
import com.wxf.commons.enums.DBType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 数据源
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 14:59:35
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Datasource extends BaseEntity {

    // ID
    @TableId(type = IdType.AUTO)
    private Long id;

    // 数据源名称
    private String datasourceName;

    // 数据源类型
    private DBType dbType;

    // 主机名
    private String host;

    // 端口
    private String port;

    // 用户名
    private String username;

    // 密码
    private String password;

    // principal
    private String principal;

    // keytab
    private String keytab;

    // 配置
    private String config;

    // 备注
    private String remark;

}
