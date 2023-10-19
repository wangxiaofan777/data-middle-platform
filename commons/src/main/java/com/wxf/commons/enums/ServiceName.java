package com.wxf.commons.enums;

public enum ServiceName implements BaseEnum {
    USER_SERVICE(0, "用户服务");

    private final Integer code;
    private final String message;

    ServiceName(Integer code, String message) {
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
