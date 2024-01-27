package com.wxf.dynamic.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.dynamic.datasource.config.datasource.DynamicDataSourceContextHolder;
import com.wxf.dynamic.datasource.entity.User;
import com.wxf.dynamic.datasource.mapper.UserMapper;
import com.wxf.dynamic.datasource.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wxf
 * @since 2024-01-27 15:01:01
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public List<User> getUserList() {
        DynamicDataSourceContextHolder.setDatasource("ds2");
        List<User> userList = this.baseMapper.selectList(null);
        DynamicDataSourceContextHolder.clearDataSource();
        return userList;
    }
}
