package com.wxf.job.job.shell;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wxf.job.job.AbstractJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Shell任务
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/2 17:22:32
 */
@Slf4j
@Component
public class ShellJob extends AbstractJob {

    private ShellJobExecutionArgs shellJobExecutionArgs = new ShellJobExecutionArgs();

    @Override
    public String getName() {
        return String.format("SHELL_%s", shellJobExecutionArgs.getAppName());
    }

    @Override
    public void init(String jobConfig) {
        log.info("job config: {}", jobConfig);
        Gson gson = new GsonBuilder().create();
        shellJobExecutionArgs = gson.fromJson(jobConfig, ShellJobExecutionArgs.class);
    }

    @Override
    public void execute() {
        List<String> commands = shellJobExecutionArgs.getCommands();
        ProcessBuilder processBuilder = new ProcessBuilder(commands);

        try {
            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            log.info("spark process exitCode is: {}", exitCode);
        } catch (Exception e) {
            log.error("shell execute error", e);
        }
    }

    @Override
    public void after() {

    }
}
