package com.zy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("登录注册Model")
@Data
public class UserVo {

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("注册时确认密码")
    private String rePwd;

}