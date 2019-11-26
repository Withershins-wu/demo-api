package com.zy.vo;

import lombok.Data;

/**
 * 分页参数
 */
@Data
public class PageVo {

	private Integer pageNum = 1;
    private Integer pageSize = 10;

}
