package com.wxf.job.job.shell;

import com.oceanum.job.execution.job.JobExecutionArgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Shell任务参数
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
public class ShellJobExecutionArgs extends JobExecutionArgs {

    // shell命令
    List<String> commands;
}
