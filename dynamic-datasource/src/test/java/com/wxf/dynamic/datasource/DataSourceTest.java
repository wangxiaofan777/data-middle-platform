package com.wxf.dynamic.datasource;

import com.wxf.dynamic.datasource.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 数据源测试
 *
 * @author Wxf
 * @since 2024-01-20 14:42:28
 **/
@ActiveProfiles("dev")
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        System.out.println(this.userService.getUserList());
    }

    @Test
    void getUserListByDs1() {
        System.out.println(this.userService.getUserListByDs1());
    }

    @Test
    void getUserListByDs2() {
        System.out.println(this.userService.getUserListByDs2());
    }
}
