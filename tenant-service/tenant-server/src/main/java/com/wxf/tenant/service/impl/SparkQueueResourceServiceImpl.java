package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.wxf.tenant.mapper.SparkQueueResourceMapper;
import com.wxf.tenant.model.SparkQueueResource;
import com.wxf.tenant.service.SparkQueueResourceService;
import com.wxf.tenant.vo.SparkQueueResourceVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SparkQueueResourceServiceImpl extends ServiceImpl<SparkQueueResourceMapper, SparkQueueResource> implements SparkQueueResourceService {

    @Override
    public void addSparkQueueResource(SparkQueueResourceVo sparkQueueResourceVo) {
        SparkQueueResource sparkQueueResource = SparkQueueResource.of(sparkQueueResourceVo);
        List<SparkQueueResource> sparkQueueResourceList = this.baseMapper.selectList(new LambdaQueryWrapper<SparkQueueResource>().eq(SparkQueueResource::getQueue, sparkQueueResourceVo.getQueue()));

        Preconditions.checkArgument(CollectionUtils.isNotEmpty(sparkQueueResourceList), "资源队列不能为空！");
        this.baseMapper.insert(sparkQueueResource);
    }

    @Override
    public void deleteSparkQueueResource(Long id) {
        // 校验
        this.checkIfExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }

    @Override
    public void updateSparkQueueResource(Long id, SparkQueueResourceVo sparkQueueResourceVo) {
        // 校验
        SparkQueueResource sparkQueueResource = this.checkIfExists(id);
        // 修改
        this.baseMapper.updateById(sparkQueueResource);
    }

    @Override
    public IPage<SparkQueueResource> listSparkQueueResource(String queue, int page, int size) {
        LambdaQueryWrapper<SparkQueueResource> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotBlank(queue), SparkQueueResource::getQueue, queue);
        return this.baseMapper.selectPage(Page.of(page, size), lqw);
    }

    private SparkQueueResource checkIfExists(Long id) {
        SparkQueueResource sparkQueueResource = this.baseMapper.selectById(id);
        Preconditions.checkArgument(Objects.nonNull(sparkQueueResource), "资源队列不存在！");
        return sparkQueueResource;
    }
}
