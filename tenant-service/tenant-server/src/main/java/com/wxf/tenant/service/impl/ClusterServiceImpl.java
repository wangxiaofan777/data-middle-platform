package com.wxf.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.wxf.tenant.mapper.ClusterMapper;
import com.wxf.tenant.model.Cluster;
import com.wxf.tenant.service.ClusterService;
import com.wxf.tenant.vo.ClusterVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class ClusterServiceImpl extends ServiceImpl<ClusterMapper, Cluster> implements ClusterService {

    @Override
    public void addCluster(ClusterVo clusterVo) {
        this.baseMapper.insert(Cluster.of(clusterVo));
    }

    @Override
    public void deleteCluster(Long id) {
        // 校验
        this.checkIfExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }

    @Override
    public void updateCluster(Long id, ClusterVo clusterVo) {
        // 校验
        Cluster cluster = this.checkIfExists(id);
        // 更新
        this.baseMapper.updateById(cluster);
    }

    @Override
    public IPage<Cluster> listCluster(String clusterName, String clusterCode, int page, int size) {
        LambdaQueryWrapper<Cluster> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotBlank(clusterName), Cluster::getClusterName, clusterName);
        lqw.like(StringUtils.isNotBlank(clusterCode), Cluster::getClusterCode, clusterCode);
        return this.baseMapper.selectPage(Page.of(page, size), lqw);
    }

    private Cluster checkIfExists(Long id) {
        Cluster cluster = this.baseMapper.selectById(id);
        Preconditions.checkArgument(Objects.nonNull(cluster), "当前集群不存在！");
        return cluster;
    }
}
