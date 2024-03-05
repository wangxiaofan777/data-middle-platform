package com.wxf.dynamic.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.dynamic.datasource.config.datasource.aspect.Ds;
import com.wxf.dynamic.datasource.config.datasource.DynamicDataSourceContextHolder;
import com.wxf.dynamic.datasource.entity.User;
import com.wxf.dynamic.datasource.mapper.UserMapper;
import com.wxf.dynamic.datasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务Service实现
 *
 * @author Wxf
 * @since 2024-01-27 15:01:01
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public List<User> getUserList() {
        DynamicDataSourceContextHolder.setDatasource("ds2");
        List<User> userList = this.baseMapper.selectList(null);
        DynamicDataSourceContextHolder.clearDataSource();
        return userList;
    }

    @Override
    public List<User> getDynamicUserList() {
        DynamicDataSourceContextHolder.setDatasource("ds3");
        List<User> userList = this.baseMapper.selectList(null);
        DynamicDataSourceContextHolder.clearDataSource();
        return userList;
    }

    @Ds("ds1")
    @Override
    public List<User> getUserListByDs1() {
        log.info(DynamicDataSourceContextHolder.getDataSource());
        return this.baseMapper.selectList(null);
    }

    @Ds("ds2")
    @Override
    public List<User> getUserListByDs2() {
        log.info(DynamicDataSourceContextHolder.getDataSource());
        return this.baseMapper.selectList(null);
    }
}
