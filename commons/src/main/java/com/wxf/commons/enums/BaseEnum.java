package com.wxf.commons.enums;

/**
 * Base 枚举
 *
 * @author WangMaoSong
 * @since 2022/10/20 14:10
 */
public interface BaseEnum {

    /**
     * 获取code值
     *
     * @return 码值
     */
    Integer getCode();


    /**
     * 描述信息
     *
     * @return 描述信息
     */
    String getMessage();

}
