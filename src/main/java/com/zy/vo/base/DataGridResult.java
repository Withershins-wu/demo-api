package com.zy.vo.base;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页
 *
 */
@ApiModel
public class DataGridResult<T> {

    @ApiModelProperty("数据总数")
    private long total;

    @ApiModelProperty("所有数据")
    private List<T> rowsList;

    public DataGridResult() {
    }

    public DataGridResult(List<T> rowsList) {
        this.total = new PageInfo<>(rowsList).getTotal();
        this.rowsList = rowsList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRowsList() {
        return rowsList;
    }

    public void setRowsList(List<T> rowsList) {
        this.rowsList = rowsList;
    }

}
