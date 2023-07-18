package com.wxf.commons.enums;

/**
 * 通用返回码
 *
 * @author WangMaoSong
 * @date 2022/10/20 14:15
 */
public enum BaseHttpCode implements BaseEnum {

    /* 成功 */
    SUCCESS(200, "成功"),

    //默认失败
    COMMON_FAIL(3000, "失败"),

    ERROR(3001, "系统繁忙，请稍后重试"),

    NULL_POINTER(3002, "空指针异常"),
    ;


    private final int code;
    private final String message;


    BaseHttpCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
