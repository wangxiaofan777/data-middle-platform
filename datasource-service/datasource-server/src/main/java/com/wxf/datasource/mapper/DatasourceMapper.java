package com.wxf.datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.datasource.model.Datasource;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源Mapper
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 15:14:35
 */
@Mapper
public interface DatasourceMapper extends BaseMapper<Datasource> {
}
