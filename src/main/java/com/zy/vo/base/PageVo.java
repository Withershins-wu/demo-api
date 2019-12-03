package com.zy.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页参数
 */
@ApiModel("分页")
@Data
public class PageVo {

    @ApiModelProperty("当前页")
	private Integer pageNum = 1;
    @ApiModelProperty("每页个数")
    private Integer pageSize = 10;

}
