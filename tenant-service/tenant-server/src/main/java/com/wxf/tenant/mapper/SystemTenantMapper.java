package com.wxf.tenant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.tenant.model.SystemTenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户租户映射Mapper
 */
@Mapper
public interface SystemTenantMapper extends BaseMapper<SystemTenant> {
}
