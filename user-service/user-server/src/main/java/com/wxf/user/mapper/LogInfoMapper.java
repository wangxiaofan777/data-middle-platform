package com.wxf.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.user.entity.LogInfo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志信息Mapper
 *
 * @author Wxf
 * @since 2023-10-27 22:54:49
 **/
@Mapper
@CacheNamespace
public interface LogInfoMapper extends BaseMapper<LogInfo> {
}
