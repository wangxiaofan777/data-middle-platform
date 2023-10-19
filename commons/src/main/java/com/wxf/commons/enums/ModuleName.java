package com.wxf.commons.enums;

import lombok.Getter;

/**
 * 模块名
 *
 * @author wxf
 * @since 2023-10-19 20:14
 **/
public enum ModuleName implements BaseEnum {
    USER(0, "用户中心", "用户服务");

    private final Integer code;
    @Getter
    private final String name;
    private final String message;

    ModuleName(Integer code, String name, String message) {
        this.code = code;
        this.name = name;
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
