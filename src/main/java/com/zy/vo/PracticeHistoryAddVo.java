package com.zy.vo;

import com.zy.vo.base.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("添加练习记录")
@Data
public class PracticeHistoryAddVo extends PageVo {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("题目名")
    private String title;

    @ApiModelProperty("是否通过 0：不通过 1：通过")
    private Byte status;
}
