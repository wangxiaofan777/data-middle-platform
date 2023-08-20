package com.wxf.job.model;

import com.wxf.job.enums.JobStatus;
import com.wxf.job.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 任务执行实体
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/25 10:58:35
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Job extends BaseEntity implements Serializable {

    // 任务名称
    private String appName;

    // 任务配置
    private String jobConfig;

    // 任务类型
    private JobType jobType;

    // 任务状态
    private JobStatus status;

    // 失败原因
    private String failReason;

    // Yarn applicationId
    private String applicationId;

    // 任务开始时间
    private LocalDateTime startTime;

    // 任务结束时间
    private LocalDateTime endTime;
}
