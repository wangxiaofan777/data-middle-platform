package com.wxf.dynamic.datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.dynamic.datasource.entity.User;

import java.util.List;

/**
 * @author Wxf
 * @since 2024-01-27 15:25:16
 **/
public interface UserService extends IService<User> {


    List<User> getUserList();
}
