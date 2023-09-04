package com.wxf.tenant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.tenant.model.SparkQueueResource;
import com.wxf.tenant.vo.SparkQueueResourceVo;

public interface SparkQueueResourceService extends IService<SparkQueueResource> {

    /**
     * 新增资源队列
     *
     * @param sparkQueueResourceVo spark资源队列
     */
    void addSparkQueueResource(SparkQueueResourceVo sparkQueueResourceVo);

    /**
     * 根据ID删除Spark资源队列
     *
     * @param id ID
     */
    void deleteSparkQueueResource(Long id);

    /**
     * 根据ID修改Spark资源队列
     *
     * @param id ID
     */
    void updateSparkQueueResource(Long id, SparkQueueResourceVo sparkQueueResourceVo);

    /**
     * 分页列表
     *
     * @param queue 队列名称
     * @param page  页码
     * @param size  大小
     * @return 分页
     */
    IPage<SparkQueueResource> listSparkQueueResource(String queue, int page, int size);

}
