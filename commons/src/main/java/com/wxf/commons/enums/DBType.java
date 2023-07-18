package com.wxf.commons.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 数据库枚举
 *
 * @author WangMaoSong
 * @version 1.1.0
 * @since 2023/7/18 14:22:28
 */
public enum DBType implements BaseEnum {
    MYSQL(1, "MYSQL"),
    HIVE(2, "HIVE"),
    REDIS(3, "REDIS"),
    MONGODB(4, "MONGODB"),
    HBASE(5, "HBASE"),
    SPARK(6, "SPARK"),
    HDFS(7, "HDFS"),


    ;


    // 码值
    @EnumValue
    @JsonValue
    private final int code;

    // 名称
    private final String name;

    DBType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.name;
    }


}
