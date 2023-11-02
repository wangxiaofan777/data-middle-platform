package com.wxf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.user.entity.LogInfo;

/**
 * 日志信息Service
 *
 * @author Wxf
 * @since 2023-10-27 22:53:22
 **/
public interface LogInfoService extends IService<LogInfo> {

    /**
     * 根据ID查询日志信息
     *
     * @param id ID
     * @return 日志信息
     */
    LogInfo getLogInfoByd(Long id);

    /**
     * 添加日志
     *
     * @param logInfo 日志信息
     * @return 操作结果
     */
    boolean addLogInfo(LogInfo logInfo);
}
