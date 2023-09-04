package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.tenant.mapper.SystemTenantMapper;
import com.wxf.tenant.model.ClusterTenant;
import com.wxf.tenant.service.ClusterTenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClusterTenantServiceImpl extends ServiceImpl<SystemTenantMapper, ClusterTenant> implements ClusterTenantService {
}
