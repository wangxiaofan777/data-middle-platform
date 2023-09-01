package com.wxf.tenant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.tenant.model.Tenant;
import com.wxf.tenant.vo.TenantVo;

/**
 * 租户Service
 */
public interface TenantService extends IService<Tenant> {

    /**
     * 添加租户
     *
     * @param tenantVo 租户Vo
     */
    void addTenant(TenantVo tenantVo) throws InterruptedException;

    /**
     * 根据租户ID删除租户
     *
     * @param id 租户ID
     */
    void deleteTenantById(Long id) throws InterruptedException;

    /**
     * 根据租户ID修改租户
     *
     * @param id       租户ID
     * @param tenantVo 租户Vo
     */
    void updateTenant(Long id, TenantVo tenantVo) throws InterruptedException;

    /**
     * 查询租户分页列表
     *
     * @param tenantName 租户名称
     * @param principal  principal
     * @param keytab     keytab
     * @param enabled    是否启用
     * @param page       页码
     * @param size       大小
     * @return 租户分页列表
     */
    IPage<Tenant> listTenant(String tenantName, String principal, String keytab, Boolean enabled, int page, int size);
}
