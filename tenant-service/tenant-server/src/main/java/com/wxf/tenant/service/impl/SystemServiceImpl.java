package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.tenant.mapper.SystemMapper;
import com.wxf.tenant.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SystemServiceImpl extends ServiceImpl<SystemMapper, System> implements SystemService {
}
