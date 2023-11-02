package com.wxf.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.user.entity.LogInfo;
import com.wxf.user.mapper.LogInfoMapper;
import com.wxf.user.service.LogInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志信息Service实现
 *
 * @author Wxf
 * @since 2023-10-27 22:54:12
 **/
@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

    //    @Cacheable("logInfo")
    @Override
    public LogInfo getLogInfoByd(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addLogInfo(LogInfo logInfo) {
        return this.baseMapper.insert(logInfo) == 1;
    }

}
