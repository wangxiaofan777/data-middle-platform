package com.wxf.tenant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.tenant.model.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户Mapper
 */
@Mapper
public interface TenantMapper extends BaseMapper<Tenant> {
}
