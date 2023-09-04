package com.wxf.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wxf.commons.enums.BaseEntity;
import com.wxf.tenant.vo.SparkQueueResourceVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * Spark 资源配置
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SparkQueueResource extends BaseEntity implements Serializable {

    // ID
    @TableId(type = IdType.AUTO)
    private Long id;

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


    public static SparkQueueResource of(SparkQueueResourceVo sparkQueueResourceVo) {
        return SparkQueueResource.builder()
                .queue(sparkQueueResourceVo.getQueue())
                .driverCores(sparkQueueResourceVo.getDriverCores())
                .driverMemory(sparkQueueResourceVo.getDriverMemory())
                .executorNum(sparkQueueResourceVo.getExecutorNum())
                .executorCores(sparkQueueResourceVo.getExecutorCores())
                .executorMemory(sparkQueueResourceVo.getExecutorMemory())
                .timeOut(sparkQueueResourceVo.getTimeOut())
                .additionArgs(sparkQueueResourceVo.getAdditionArgs())
                .config(sparkQueueResourceVo.getConfig())
                .build();
    }

}
