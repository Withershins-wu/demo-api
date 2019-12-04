package com.zy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("历史记录")
@Data
public class PracticeHistoryVo {
    private Integer id;

    @ApiModelProperty("题目名")
    private String title;

    private String url;

    private String memo;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    @ApiModelProperty("习题状态 0：不通过 1：通过")
    private Byte status;

}