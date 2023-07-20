package com.wxf.user.config.mybatis.plus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 全局字段填充器
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 10:08:23
 */
@Configuration
public class GlobalMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        String username = this.getUsername();
        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, "createBy", String.class, username);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, now);
        // 空值才会填充
        this.strictUpdateFill(metaObject, "updateBy", String.class, username);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateBy", this.getUsername(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 从上下文中获取用户名
     *
     * @return 用户名
     */
    private String getUsername() {
        return "admin";
    }
}
