package com.wxf.tenant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.tenant.model.Cluster;
import com.wxf.tenant.vo.ClusterVo;

public interface ClusterService extends IService<Cluster> {

    /**
     * 添加集群
     *
     * @param clusterVo 集群Vo
     */

    void addCluster(ClusterVo clusterVo);


    /**
     * 根据ID删除集群
     *
     * @param id ID
     */
    void deleteCluster(Long id);


    /**
     * 根据ID修改集群
     *
     * @param id        ID
     * @param clusterVo 集群Vo
     */
    void updateCluster(Long id, ClusterVo clusterVo);

    /**
     * 查询集群
     *
     * @param clusterName 集群名称
     * @param clusterCode 集群编码
     * @param page        页码
     * @param size        大小
     * @return
     */
    IPage<Cluster> listCluster(String clusterName, String clusterCode, int page, int size);


}
