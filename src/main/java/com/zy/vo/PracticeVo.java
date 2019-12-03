package com.zy.vo;

import com.zy.vo.base.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("题库列表搜索条件Vo")
@Data
public class PracticeVo extends PageVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("链接")
    private String url;

    @ApiModelProperty("描述")
    private String memo;

    @ApiModelProperty("题目类型")
    private Integer type;

}