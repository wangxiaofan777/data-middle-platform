package com.wxf.user.dubbo.provider;


import com.wxf.user.provider.UserDo;
import com.wxf.user.provider.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

@DubboService
public class UserServiceProvider implements UserService {

    @Override
    public List<UserDo> getUserList() {
        return Arrays.asList(
                UserDo.builder().id(1L).name("wxf").build(),
                UserDo.builder().id(2L).name("rc").build()
        );
    }
}
