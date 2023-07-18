package com.wxf.datasource.mapper;

import com.wxf.commons.enums.BaseEntity;
import com.wxf.commons.enums.DBType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 数据源
 *
 * @author WangMaoSong
 * @version 1.1.0
 * @since 2023/7/18 14:59:35
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DatasourceVo extends BaseEntity {

    // 数据源名称
    @NotBlank(message = "数据源名称不能为空")
    private String datasourceName;

    // 数据源类型
    @NotNull(message = "数据源类型不能为空")
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
