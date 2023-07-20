package com.wxf.datasource.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wxf.commons.enums.DBType;
import com.wxf.commons.utils.HttpResult;
import com.wxf.datasource.mapper.DatasourceVo;
import com.wxf.datasource.service.IDatasourceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据源Controller
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 15:17:30
 */
@RestController
public class DatasourceController {

    private final IDatasourceService datasourceService;

    public DatasourceController(IDatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }

    /**
     * 新增数据源
     *
     * @param datasourceVo 数据源Vo
     */
    @PostMapping
    public HttpResult<Long> addDatasource(@Validated DatasourceVo datasourceVo) {
        return HttpResult.success(this.datasourceService.addDatasource(datasourceVo));
    }

    /**
     * 修改数据源
     *
     * @param id           ID
     * @param datasourceVo 数据源Vo
     */
    @PutMapping("/{id}")
    public HttpResult<Void> updateDatasource(@PathVariable Long id,
                                             @Validated DatasourceVo datasourceVo) {
        this.datasourceService.updateDatasource(id, datasourceVo);
        return HttpResult.success();
    }

    /**
     * 删除数据源
     *
     * @param id ID
     */
    @DeleteMapping("/{id}")
    public HttpResult<Void> deleteDatasource(@PathVariable Long id) {
        this.datasourceService.deleteDatasource(id);
        return HttpResult.success();
    }


    /**
     * 查询数据源分页
     *
     * @param datasourceName 数据源名称
     * @param dbType         数据源类型
     * @param page           页码
     * @param size           大小
     */
    @GetMapping("/list")
    public HttpResult<IPage<DatasourceVo>> listDatasource(@RequestParam(value = "datasourceName", required = false) String datasourceName,
                                                          @RequestParam(value = "dbType", required = false) DBType dbType,
                                                          @RequestParam(value = "page", defaultValue = "1", required = false) int page,
                                                          @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        return HttpResult.success(this.datasourceService.listDatasource(datasourceName, dbType, page, size));
    }
}
