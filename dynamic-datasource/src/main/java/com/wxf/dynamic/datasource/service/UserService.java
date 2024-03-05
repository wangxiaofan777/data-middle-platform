package com.wxf.dynamic.datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.dynamic.datasource.entity.User;

import java.util.List;

/**
 * 用户服务Service
 *
 * @author Wxf
 * @since 2024-01-27 15:25:16
 **/
public interface UserService extends IService<User> {


    /**
     * 手动切换数据源
     *
     * @return 用户列表
     */
    List<User> getUserList();

    /**
     * 手动切换数据源
     *
     * @return 用户列表
     */
    List<User> getDynamicUserList();

    /**
     * 注解切换数据源1
     *
     * @return 用户列表
     */
    List<User> getUserListByDs1();

    /**
     * 注解切换数据源2
     *
     * @return 用户列表
     */
    List<User> getUserListByDs2();

}
