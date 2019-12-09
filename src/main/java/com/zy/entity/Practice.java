package com.zy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class Practice {
    private Integer id;

    @ApiModelProperty("题目名")
    private String title;

    @ApiModelProperty("连接")
    private String url;

    private String memo;

    private Integer type;

    private Date createTime;

    private Date updateTime;

}