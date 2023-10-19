package com.wxf.job.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Hive数据查询
 *
 * @author wxf
 * @version 1.1.0
 * @since 2023/6/15 14:47:07
 */
@Slf4j
@Service
public class HiveServiceImpl implements HiveService {

    private final JdbcTemplate jdbcTemplate;

    public HiveServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



}
