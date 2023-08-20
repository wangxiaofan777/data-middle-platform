package com.wxf.job.job;

import com.wxf.job.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 任务执行
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/29 15:40:00
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class JobExecutionArgs implements Serializable {

    // 名称
    private String appName;

    // 任务类型
    private JobType jobType;

}
