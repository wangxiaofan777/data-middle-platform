package com.wxf.job.controller;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author WangMaoSong
 * @version 1.1.0
 * @since 2023/5/23 15-40:50
 */
@RestController
public class HiveController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hive")
    public void get() {
        this.jdbcTemplate.execute("show databases ");
    }


}
