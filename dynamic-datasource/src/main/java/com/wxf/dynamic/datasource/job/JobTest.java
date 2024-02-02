package com.wxf.dynamic.datasource.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Wxf
 * @since 2024-02-01 19:03:25
 **/
@Slf4j
@EnableAsync
@EnableScheduling
@Component
public class JobTest {

    @Async
    @Scheduled(cron = "0 */1 * * * ?")
    public void test() {
        try {
            log.info("test job execute start....");
            TimeUnit.SECONDS.sleep(90);
            log.info("test job execute end....");
        } catch (InterruptedException e) {
            log.error("test job execute error", e);
        }
    }
}
