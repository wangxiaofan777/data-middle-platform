package com.wxf.user.provider;

import java.util.List;

public interface UserService {

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    List<UserDo> getUserList();

}
