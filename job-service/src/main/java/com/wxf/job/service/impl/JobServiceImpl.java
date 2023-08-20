package com.wxf.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.job.mapper.JobMapper;
import com.wxf.job.enums.JobStatus;
import com.wxf.job.model.Job;
import com.wxf.job.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Job Service 实现
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/5 12:47:35
 */
@Slf4j
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Override
    public String getJobConfigById(String id) {
        return Optional.of(this.getById(id)).map(Job::getJobConfig).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateJobById(String id, String applicationId, JobStatus jobStatus, String failReason, LocalDateTime startTime, LocalDateTime endTime) {
        Job job = this.baseMapper.selectById(id);
        if (StringUtils.isNotBlank(applicationId)) {
            job.setApplicationId(applicationId);
        }
        if (Objects.nonNull(jobStatus)) {
            job.setStatus(jobStatus);
        }
        if (StringUtils.isNotBlank(failReason)) {
            job.setFailReason(failReason);
        }
        if (Objects.nonNull(startTime)) {
            job.setStartTime(startTime);
        }
        if (Objects.nonNull(endTime)) {
            job.setEndTime(endTime);
        }

        this.baseMapper.updateById(job);
    }
}
