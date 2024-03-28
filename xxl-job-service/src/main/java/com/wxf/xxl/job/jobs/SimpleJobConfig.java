package com.wxf.xxl.job.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Wxf
 * @since 2024-03-07 15:36:31
 **/
@Slf4j
@Component
public class SimpleJobConfig {

    @XxlJob("test")
    public ReturnT<String> test(){
        return ReturnT.SUCCESS;
    }
}
