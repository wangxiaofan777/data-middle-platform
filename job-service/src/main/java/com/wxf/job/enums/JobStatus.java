package com.wxf.job.enums;

/**
 * 任务执行状态枚举
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/25 10-59:56
 */
public enum JobStatus {
    INIT(1, "初始化"),
    STARTED(2, "已启动"),
    RUNNING(3, "运行中"),
    SUCCESS(4, "成功"),
    FAILED(5, "失败"),

    ;

    private final int code;
    private final String describe;

    JobStatus(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
