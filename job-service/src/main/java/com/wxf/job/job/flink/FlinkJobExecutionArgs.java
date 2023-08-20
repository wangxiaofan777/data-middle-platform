package com.wxf.job.job.flink;

import com.oceanum.job.execution.job.JobExecutionArgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Flink任务参数
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/2 13:25:27
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FlinkJobExecutionArgs extends JobExecutionArgs {

    private String app;

    // FLINK_HOME
    private String flinkHome;
}
