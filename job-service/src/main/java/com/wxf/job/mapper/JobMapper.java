package com.wxf.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxf.job.model.Job;
import org.apache.ibatis.annotations.Mapper;

/**
 * Job Mapper
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/5 12:46:40
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {
}
