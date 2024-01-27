package com.wxf.dynamic.datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.dynamic.datasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wxf
 * @since 2024-01-27 15:26:47
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
