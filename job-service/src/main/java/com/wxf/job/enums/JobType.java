package com.wxf.job.enums;

/**
 * 任务类型
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/26 15-28:23
 */
public enum JobType {
    SPARK(1),
    PY_SPARK(2),
    FLINK(3),
    SHELL(4),


    ;


    private final int code;

    JobType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
