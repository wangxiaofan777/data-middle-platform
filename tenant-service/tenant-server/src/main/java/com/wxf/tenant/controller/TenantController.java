package com.wxf.tenant.controller;

import com.wxf.tenant.service.TenantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 租户Controller
 */
@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Resource
    private TenantService tenantService;



}
