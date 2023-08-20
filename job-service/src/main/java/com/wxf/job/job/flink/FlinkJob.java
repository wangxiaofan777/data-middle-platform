package com.wxf.job.job.flink;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oceanum.job.execution.job.AbstractJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.client.deployment.ClusterDeploymentException;
import org.apache.flink.client.deployment.ClusterSpecification;
import org.apache.flink.client.deployment.application.ApplicationConfiguration;
import org.apache.flink.client.program.ClusterClient;
import org.apache.flink.client.program.ClusterClientProvider;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.yarn.YarnClientYarnClusterInformationRetriever;
import org.apache.flink.yarn.YarnClusterDescriptor;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.springframework.stereotype.Component;

/**
 * Flink任务
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/2 17:38:33
 */
@Slf4j
@Component
public class FlinkJob extends AbstractJob {

    private FlinkJobExecutionArgs flinkJobExecutionArgs = new FlinkJobExecutionArgs();

    @Override
    protected String getName() {
        return String.format("Flink_%s", flinkJobExecutionArgs.getAppName());
    }

    @Override
    protected void init(String jobConfig) {
        log.info("job config: {}", jobConfig);
        Gson gson = new GsonBuilder().create();
        flinkJobExecutionArgs = gson.fromJson(jobConfig, FlinkJobExecutionArgs.class);
    }

    @Override
    protected void execute() {
        YarnConfiguration yarnConfiguration = new YarnConfiguration();
        YarnClient yarnClient = YarnClient.createYarnClient();

        yarnClient.init(yarnConfiguration);

        Configuration flinkConfiguration = new Configuration();
        YarnClusterDescriptor yarnClusterDescriptor = new YarnClusterDescriptor(flinkConfiguration,
                yarnConfiguration,
                yarnClient,
                YarnClientYarnClusterInformationRetriever.create(yarnClient),
                false);
        ClusterSpecification clusterSpecification = new ClusterSpecification.ClusterSpecificationBuilder()
                .setMasterMemoryMB(1000)
                .setTaskManagerMemoryMB(1000)
                .setSlotsPerTaskManager(10)
                .createClusterSpecification();

        try {
            ClusterClientProvider<ApplicationId> provider = yarnClusterDescriptor.deployApplicationCluster(clusterSpecification,
                    new ApplicationConfiguration(new String[0], ""));
            ClusterClient<ApplicationId> clusterClient = provider.getClusterClient();
            String applicationId = clusterClient.getClusterId().toString();
            String webInterfaceURL = clusterClient.getWebInterfaceURL();

        } catch (ClusterDeploymentException e) {
            log.error("execute flink job error", e);
        }

    }

    @Override
    protected void after() {

    }
}
