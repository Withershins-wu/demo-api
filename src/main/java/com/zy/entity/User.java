package com.zy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String telephone;

    private String email;

    private String name;

    private String pwd;

    private Date createTime;

    private Date updateTime;

}