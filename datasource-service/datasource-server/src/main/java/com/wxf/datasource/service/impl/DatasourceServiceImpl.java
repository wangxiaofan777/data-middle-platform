package com.wxf.datasource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxf.commons.enums.DBType;
import com.wxf.datasource.mapper.DatasourceMapper;
import com.wxf.datasource.mapper.DatasourceVo;
import com.wxf.datasource.model.Datasource;
import com.wxf.datasource.service.IDatasourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 数据源Service实现
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 15:16:09
 */
@Slf4j
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

    @Override
    public Long addDatasource(DatasourceVo datasourceVo) {
        Datasource datasource = new Datasource();
        BeanUtils.copyProperties(datasourceVo, datasource);
        this.baseMapper.insert(datasource);
        return datasource.getId();
    }

    @Override
    public void updateDatasource(Long id, DatasourceVo datasourceVo) {
        Datasource datasource = this.baseMapper.selectById(id);
        BeanUtils.copyProperties(datasourceVo, datasource);
        this.baseMapper.updateById(datasource);
    }

    @Override
    public void deleteDatasource(Long id) {
        this.baseMapper.deleteById(id);
    }

    @Override
    public IPage<DatasourceVo> listDatasource(String datasourceName, DBType dbType, int page, int size) {
        LambdaQueryWrapper<Datasource> qw = new LambdaQueryWrapper<>();
        qw.like(StringUtils.isNotBlank(datasourceName), Datasource::getDatasourceName, datasourceName);
        qw.eq(Objects.nonNull(dbType), Datasource::getDbType, dbType);
        return this.baseMapper.selectPage(Page.of(page, size), qw)
                .convert(datasource -> {
                    DatasourceVo datasourceVo = new DatasourceVo();
                    BeanUtils.copyProperties(datasource, datasourceVo);
                    return datasourceVo;
                });
    }
}
