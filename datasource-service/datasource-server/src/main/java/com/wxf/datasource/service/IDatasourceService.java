package com.wxf.datasource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxf.commons.enums.DBType;
import com.wxf.datasource.mapper.DatasourceVo;
import com.wxf.datasource.model.Datasource;

/**
 * 数据源Service
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 15:15:25
 */
public interface IDatasourceService extends IService<Datasource> {


    /**
     * 新增数据源
     *
     * @param datasourceVo 数据源Vo
     * @return
     */
    Long addDatasource(DatasourceVo datasourceVo);

    /**
     * 修改数据源
     *
     * @param id           ID
     * @param datasourceVo 数据源Vo
     */

    void updateDatasource(Long id, DatasourceVo datasourceVo);

    /**
     * 删除数据源
     *
     * @param id ID
     */
    void deleteDatasource(Long id);


    /**
     * 查询数据源分页
     *
     * @param datasourceName 数据源名称
     * @param dbType         数据源类型
     * @param page           页码
     * @param size           大小
     * @return 分页列表
     */
    IPage<DatasourceVo> listDatasource(String datasourceName, DBType dbType, int page, int size);


}
