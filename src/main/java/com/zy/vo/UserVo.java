package com.zy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserVo {

    @ApiModelProperty()
    private String email;

    private String pwd;

    private String rePwd;

}