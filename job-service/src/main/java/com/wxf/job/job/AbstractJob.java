package com.wxf.job.job;

import com.google.common.base.Preconditions;
import com.wxf.job.enums.JobStatus;
import com.wxf.job.service.JobService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * 抽象任务
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/29 15:49:17
 */
@Slf4j
public abstract class AbstractJob implements Job {

    @Resource
    protected JobService jobService;

    protected String id;


    @Override
    public void submit(String id) {
        this.id = id;

        try {
            String jobConfig = this.jobService.getJobConfigById(id);

            Preconditions.checkArgument(StringUtils.isNotBlank(jobConfig), "任务参数不能为空");

            init(jobConfig);

            this.jobService.updateJobById(id, null, JobStatus.RUNNING, null,  LocalDateTime.now(), LocalDateTime.now());

            execute();
        } catch (Exception e) {
            log.error("job {} submit error", id, e);
            this.jobService.updateJobById(id, null, JobStatus.FAILED, e.getMessage(), null, LocalDateTime.now());
            throw new RuntimeException(e);
        } finally {
            after();
        }
    }


    /**
     * 获取任务名称
     *
     * @return 任务名称
     */
    protected abstract String getName();

    /**
     * 初始化任务参数
     *
     * @param jobConfig 任务配置
     */
    protected abstract void init(String jobConfig);

    /**
     * 任务执行
     */
    protected abstract void execute();

    /**
     * 任务执行后操作
     */
    protected void after() {
        this.jobService.updateJobById(id, null, JobStatus.SUCCESS, null, null, LocalDateTime.now());
    }
}
