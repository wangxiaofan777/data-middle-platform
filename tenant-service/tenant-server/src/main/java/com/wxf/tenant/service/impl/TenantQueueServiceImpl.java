package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.tenant.mapper.TenantQueueMapper;
import com.wxf.tenant.model.TenantQueue;
import com.wxf.tenant.service.TenantQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TenantQueueServiceImpl extends ServiceImpl<TenantQueueMapper, TenantQueue> implements TenantQueueService {
}
