package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.wxf.tenant.mapper.TenantMapper;
import com.wxf.tenant.model.Tenant;
import com.wxf.tenant.service.TenantService;
import com.wxf.tenant.vo.TenantVo;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 租户Service实现
 */
@Slf4j
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {

    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void addTenant(TenantVo tenantVo) throws InterruptedException {
        boolean locked = lock.tryLock(1, TimeUnit.SECONDS);

        Preconditions.checkArgument(locked, "添加租户失败！");

        try {
            // 校验租户名称是否重复
            this.checkTenantNameIfExist(null, tenantVo.getTenantName());
            // 新增租户
            this.baseMapper.insert(Tenant.of(tenantVo));
        } catch (Exception e) {
            log.error("add tenant error", e);
            throw new RuntimeException("添加租户失败!");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void deleteTenantById(Long id) throws InterruptedException {
        boolean locked = lock.tryLock(1, TimeUnit.SECONDS);

        Preconditions.checkArgument(locked, "删除租户失败！");
        try {
            // 根据租户ID校验租户是否存在
            this.checkExistById(id);
            // 删除租户
            this.baseMapper.deleteById(id);
        } catch (Exception e) {
            log.error("delete tenant error", e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void updateTenant(Long id, TenantVo tenantVo) throws InterruptedException {

        boolean locked = lock.tryLock(1, TimeUnit.SECONDS);

        Preconditions.checkArgument(locked, "修改租户失败！");
        try {
            // 校验租户名称是否重复
            this.checkTenantNameIfExist(id, tenantVo.getTenantName());

            // 根据租户ID校验租户是否存在
            Tenant tenant = this.checkExistById(id);

            // 更新租户
            Tenant.of(tenant, tenantVo);
            this.baseMapper.updateById(tenant);
        } catch (Exception e) {
            log.error("update tenant error", e);
            throw new RuntimeException("修改租户失败！");
        } finally {
            lock.unlock();
        }

    }

    @Override
    public IPage<Tenant> listTenant(String tenantName, String principal, String keytab, Boolean enabled, int page, int size) {
        LambdaQueryWrapper<Tenant> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotBlank(tenantName), Tenant::getTenantName, tenantName);
        lqw.like(StringUtils.isNotBlank(principal), Tenant::getPrincipal, principal);
        lqw.like(StringUtils.isNotBlank(keytab), Tenant::getKeytab, keytab);
        lqw.eq(Objects.nonNull(enabled), Tenant::getEnabled, enabled);
        return this.baseMapper.selectPage(Page.of(page, size), lqw);
    }

    /**
     * 校验租户名称是否重复
     *
     * @param id         租户ID
     * @param tenantName 租户名称
     */
    private void checkTenantNameIfExist(@Nullable Long id, String tenantName) {
        LambdaQueryWrapper<Tenant> qw = new LambdaQueryWrapper<>();
        qw.eq(Tenant::getTenantName, tenantName);
        qw.ne(Objects.nonNull(id), Tenant::getId, id);
        List<Tenant> tenantList = this.baseMapper.selectList(qw);

        Preconditions.checkArgument(CollectionUtils.isEmpty(tenantList), "租户名称不能重复！");
    }

    /**
     * 根据租户ID校验租户是否存在
     *
     * @param id 租户ID
     */
    private Tenant checkExistById(Long id) {
        Tenant tenant = this.baseMapper.selectById(id);
        Preconditions.checkArgument(Objects.nonNull(tenant), "当前租户不存在！");
        return tenant;
    }
}
