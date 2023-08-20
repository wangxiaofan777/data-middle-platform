package com.wxf.job.job.spark;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wxf.job.config.KerberosAuth;
import com.wxf.job.config.SpringApplicationContext;
import com.wxf.job.enums.JobStatus;
import com.wxf.job.job.AbstractJob;
import com.wxf.job.service.JobService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Spark任务
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/29 15:40:48
 */
@Slf4j
@Component
public class SparkJob extends AbstractJob {

    private static final String SPARK_DRIVER_CORES = "spark.driver.cores";
    private static final String SPARK_EXECUTOR_CORES = "spark.executor.cores";
    private static final String SPARK_YARN_QUEUE = "spark.yarn.queue";
    private static final String SPARK_YARN_PRINCIPAL = "spark.yarn.principal";
    private static final String SPARK_YARN_KEYTAB = "spark.yarn.keytab";
    private static final String SPARK_YARN_KERBEROS_RELOGIN_PERIOD = "spark.yarn.kerberos.relogin.period";


    private static final String SPARK_KERBEROS_PRINCIPAL = "spark.kerberos.principal";
    private static final String SPARK_KERBEROS_KEYTAB = "spark.kerberos.keytab";
    private static final String SPARK_KERBEROS_RELOGIN_PERIOD = "spark.kerberos.relogin.period";

    private SparkJobExecutionArgs sparkJobExecutionArgs = new SparkJobExecutionArgs();

    @Resource
    private SparkConfiguration sparkConfiguration;
    @Resource
    private KerberosAuth kerberosAuth;
    @Resource
    private JobService jobService;

    @Override
    public String getName() {
        return String.format("SPARK_%s", sparkJobExecutionArgs.getAppArgs());
    }

    @Override
    public void init(String jobConfig) {
        log.info("job config: {}", jobConfig);
        Gson gson = new GsonBuilder().create();
        sparkJobExecutionArgs = gson.fromJson(jobConfig, SparkJobExecutionArgs.class);
//        sparkJobExecutionArgs = SparkJobExecutionArgs.builder()
//                .appName("测试")
//                .master("yarn")
//                .deployMode("cluster")
//                .mainClass("com.oceanum.loader.DxLoader")
//                .appResource("/home/wms/loader-service-1.1.0-SNAPSHOT.jar")
//                .build();
    }

    @Override
    public void execute() {
        SparkLauncher launcher = new SparkLauncher();
        loadSparkConfig(launcher);
        try {
            Process process = launcher.launch();

            launcher.startApplication(new SparkAppHandle.Listener() {
                @Override
                public void stateChanged(SparkAppHandle handle) {
                    SparkAppHandle.State state = handle.getState();
                    log.info("current job status is : {}", state);
                    JobStatus jobStatus = null;
                    LocalDateTime endTime = null;
                    switch (state) {
                        case RUNNING:
                        case SUBMITTED:
                        case CONNECTED:
                            jobStatus = JobStatus.RUNNING;
                            break;
                        case FAILED:
                        case UNKNOWN:
                        case KILLED:
                        case LOST:
                            jobStatus = JobStatus.FAILED;
                            endTime = LocalDateTime.now();
                            break;
                        case FINISHED:
                            jobStatus = JobStatus.SUCCESS;
                            endTime = LocalDateTime.now();
                            break;
                        default:
                            break;
                    }
                    SpringApplicationContext.getBean(JobService.class).updateJobById(id, handle.getAppId(), jobStatus, null, null, endTime);
                }

                @Override
                public void infoChanged(SparkAppHandle handle) {
                    log.info("current job status is : {}", handle.getState());
                }
            });

            int exitCode = process.waitFor();

            log.info("spark process exitCode is: {}", exitCode);

        } catch (Exception e) {
            log.error("spark execute error", e);
        }
    }

    @Override
    public void after() {

    }


    /**
     * 加载Spark配置
     *
     * @param launcher spark启动器
     */
    private void loadSparkConfig(SparkLauncher launcher) {
        String appName = sparkJobExecutionArgs.getAppName();
        launcher.setAppName(StringUtils.isNotBlank(appName) ? appName : getName());

        String master = sparkJobExecutionArgs.getMaster();
        Preconditions.checkArgument(StringUtils.isNotBlank(master), "master不能为空");
        launcher.setMaster(master);

        String deployMode = sparkJobExecutionArgs.getDeployMode();
        Preconditions.checkArgument(StringUtils.isNotBlank(deployMode), "deployMode不能为空");
        launcher.setDeployMode(deployMode);

        String mainClass = sparkJobExecutionArgs.getMainClass();
        Preconditions.checkArgument(StringUtils.isNotBlank(mainClass), "mainClass不能为空");
        launcher.setMainClass(mainClass);

        String appResource = sparkJobExecutionArgs.getAppResource();
        if (StringUtils.isNotBlank(appResource)) {
            launcher.setAppResource(appResource);
        }

        List<String> pyFiles = sparkJobExecutionArgs.getPyFiles();
        if (CollectionUtils.isNotEmpty(pyFiles)) {
            pyFiles.forEach(launcher::addPyFile);
        }

        String javaHome = sparkConfiguration.getJavaHome();
        if (StringUtils.isNotBlank(javaHome)) {
            launcher.setJavaHome(javaHome);
        }
        String sparkHome = sparkConfiguration.getSparkHome();
        if (StringUtils.isNotBlank(sparkHome)) {
            launcher.setSparkHome(sparkHome);
        }

        String queue = sparkJobExecutionArgs.getQueue();
        if (StringUtils.isNotBlank(queue)) {
            launcher.setConf(SPARK_YARN_QUEUE, queue);
        }

        String driverMemory = sparkJobExecutionArgs.getDriverMemory();
        if (StringUtils.isNotBlank(driverMemory)) {
            launcher.setConf(SparkLauncher.DRIVER_MEMORY, driverMemory);
        }

        String driverCores = sparkJobExecutionArgs.getDriverCores();
        if (StringUtils.isNotBlank(driverCores)) {
            launcher.setConf(SPARK_DRIVER_CORES, driverCores);
        }
        String executorCores = sparkJobExecutionArgs.getExecutorCores();
        if (StringUtils.isNotBlank(executorCores)) {
            launcher.setConf(SparkLauncher.EXECUTOR_CORES, executorCores);
        }
        String executorNum = sparkJobExecutionArgs.getExecutorNum();
        if (StringUtils.isNotBlank(executorNum)) {
            launcher.setConf(SPARK_EXECUTOR_CORES, executorNum);
        }
        String executorMemory = sparkJobExecutionArgs.getExecutorMemory();
        if (StringUtils.isNotBlank(executorMemory)) {
            launcher.setConf(SparkLauncher.EXECUTOR_MEMORY, executorMemory);
        }

        Map<String, String> config = sparkConfiguration.getConfig();
        if (MapUtils.isNotEmpty(config)) {
            config.forEach(launcher::setConf);
        }

        Map<String, String> conf = sparkJobExecutionArgs.getConf();
        if (MapUtils.isNotEmpty(conf)) {
            conf.forEach(launcher::setConf);
        }

        List<String> files = sparkJobExecutionArgs.getFiles();
        if (CollectionUtils.isNotEmpty(files)) {
            files.forEach(launcher::addFile);
        }

        List<String> jars = sparkJobExecutionArgs.getJars();
        if (CollectionUtils.isNotEmpty(jars)) {
            jars.forEach(launcher::addJar);
        }

        String propertiesFile = sparkJobExecutionArgs.getPropertiesFile();
        if (StringUtils.isNotBlank(propertiesFile)) {
            launcher.setPropertiesFile(propertiesFile);
        }

        List<String> appArgs = sparkJobExecutionArgs.getAppArgs();
        if (CollectionUtils.isNotEmpty(appArgs)) {
            launcher.addAppArgs(appArgs.stream().toArray(String[]::new));
        }

        launcher.setVerbose(sparkConfiguration.getVerbose());
    }
}
