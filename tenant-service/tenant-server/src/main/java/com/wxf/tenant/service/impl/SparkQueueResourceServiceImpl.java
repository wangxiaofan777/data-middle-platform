package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.tenant.mapper.SparkQueueResourceMapper;
import com.wxf.tenant.model.SparkQueueResource;
import com.wxf.tenant.service.SparkQueueResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SparkQueueResourceServiceImpl extends ServiceImpl<SparkQueueResourceMapper, SparkQueueResource> implements SparkQueueResourceService {
}
