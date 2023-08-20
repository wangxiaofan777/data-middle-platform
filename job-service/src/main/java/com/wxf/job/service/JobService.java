package com.wxf.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.job.model.Job;
import com.wxf.job.enums.JobStatus;

import java.time.LocalDateTime;

/**
 * Job Service
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/5 12:47:10
 */
public interface JobService extends IService<Job> {

    /**
     * 根据任务ID获取任务配置
     *
     * @param id 任务ID
     * @return 任务配置
     */
    String getJobConfigById(String id);

    /**
     * 根据任务ID更新任务
     *
     * @param id            任务ID
     * @param applicationId yarn applicationId
     * @param jobStatus     任务状态
     * @param failReason    失败原因
     * @param startTime     开始时间
     * @param endTime       结束时间
     */
    void updateJobById(String id, String applicationId, JobStatus jobStatus, String failReason, LocalDateTime startTime, LocalDateTime endTime);
}
