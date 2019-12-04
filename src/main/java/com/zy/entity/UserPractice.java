package com.zy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserPractice {
    private Integer id;

    private Integer userId;

    private Integer practiceId;

    private Byte status;

    private Date createTime;

    private Date updateTime;

}