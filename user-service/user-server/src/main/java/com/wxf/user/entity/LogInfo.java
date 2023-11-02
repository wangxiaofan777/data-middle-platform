package com.wxf.user.entity;

import com.wxf.commons.enums.BaseEntity;
import com.wxf.commons.enums.ModuleName;
import com.wxf.commons.enums.ServiceName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 日志信息
 * @author Wxf
 * @since 2023-10-19 20:49:15
 **/
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LogInfo extends BaseEntity implements Serializable {

    // 用户ID
    private Long userId;

    // 服务名
    private ServiceName serviceName;

    // 模块名
    private ModuleName moduleName;

    // 方法名
    private String methodName;

    // 参数
    private String args;

    // 描述信息
    private String message;

    // IP地址
    private String ip;

    // Mac地址
    private String mac;


}
