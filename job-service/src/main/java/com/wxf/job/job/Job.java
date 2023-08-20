package com.wxf.job.job;

/**
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/29 15:35:49
 */
public interface Job {

    /**
     * 提交任务
     *
     * @param id 任务ID
     */
    void submit(String id);

}
