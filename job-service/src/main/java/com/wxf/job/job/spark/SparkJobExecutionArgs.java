package com.wxf.job.job.spark;

import com.oceanum.job.execution.job.JobExecutionArgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

/**
 * Spark任务参数
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
public class SparkJobExecutionArgs extends JobExecutionArgs {

    // Jar包
    private String appResource;

    // yarn 、local
    private String master;

    // 部署模式 cluster、client
    private String deployMode;

    // 程序入口
    private String mainClass;

    // 队列
    private String queue;

    // driver内存
    private String driverMemory;

    // driver核数
    private String driverCores;

    // executor数
    private String executorNum;

    // executor核数
    private String executorCores;

    // executor内存
    private String executorMemory;

    // Spark 额外配置
    private String propertiesFile;

    // 程序参数
    private List<String> appArgs;

    // 依赖Jar包
    private List<String> jars;

    // files
    private List<String> files;

    // python文件
    private List<String> pyFiles;

    // conf
    private Map<String, String> conf;


}
