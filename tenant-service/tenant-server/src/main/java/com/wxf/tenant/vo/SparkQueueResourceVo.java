package com.wxf.tenant.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SparkQueueResourceVo implements Serializable {

    // 队列
    private String queue;

    // driver核数
    private Integer driverCores;

    // driver内存
    private String driverMemory;

    // executor数
    private Integer executorNum;

    // executor核数
    private Integer executorCores;

    // executor内存
    private String executorMemory;

    // 超时时间
    private Long timeOut;

    // 额外参数
    private String additionArgs;

    // 配置 --conf
    private Map<String, String> config;

}
