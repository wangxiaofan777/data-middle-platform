package com.wxf.tenant.dubbo.comsumer;

import com.wxf.user.provider.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer implements CommandLineRunner {

    @DubboReference
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.getUserList());

    }
}
