package com.wxf.commons.utils;

import com.wxf.commons.enums.BaseEnum;
import com.wxf.commons.enums.BaseHttpCode;
import lombok.Data;

import java.io.Serializable;

/**
 * HTTP返回值枚举
 *
 * @param <T>
 * @author WangXiaofan777
 */
@Data
public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据内容
     */
    private T data;

    public HttpResult() {

    }

    public HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResult<T> success() {
        return new HttpResult<>(BaseHttpCode.SUCCESS.getCode(), BaseHttpCode.SUCCESS.getMessage());
    }

    public static <T> HttpResult<T> success(T data) {
        return new HttpResult<>(BaseHttpCode.SUCCESS.getCode(), BaseHttpCode.SUCCESS.getMessage(), data);
    }

    public static <T> HttpResult<T> error(BaseEnum commonCodeCode) {
        return new HttpResult<>(commonCodeCode.getCode(), commonCodeCode.getMessage());
    }

    public static <T> HttpResult<T> error(BaseEnum commonCodeCode, T data) {
        return new HttpResult<>(commonCodeCode.getCode(), commonCodeCode.getMessage(), data);
    }

    public static <T> HttpResult<T> error() {
        return new HttpResult<>(BaseHttpCode.ERROR.getCode(), BaseHttpCode.ERROR.getMessage());
    }

    public static <T> HttpResult<T> error(String message) {
        return new HttpResult<>(BaseHttpCode.ERROR.getCode(), message);
    }

    public static HttpResult<?> error(Integer code, String message) {
        return new HttpResult<>(code, message);
    }

    public static <T> HttpResult<T> error(BaseHttpCode commonCodeCode) {
        return new HttpResult<>(commonCodeCode.getCode(), commonCodeCode.getMessage());
    }
}
