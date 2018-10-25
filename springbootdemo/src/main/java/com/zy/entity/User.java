package com.zy.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String uname;

    private Byte usex;

    private String telephone;

    private String password;

    private Integer level1Code;

    private Integer level2Code;

    private Integer level3Code;

    private String level1Name;

    private String level2Name;

    private String level3Name;

    private String address;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Byte getUsex() {
        return usex;
    }

    public void setUsex(Byte usex) {
        this.usex = usex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getLevel1Code() {
        return level1Code;
    }

    public void setLevel1Code(Integer level1Code) {
        this.level1Code = level1Code;
    }

    public Integer getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(Integer level2Code) {
        this.level2Code = level2Code;
    }

    public Integer getLevel3Code() {
        return level3Code;
    }

    public void setLevel3Code(Integer level3Code) {
        this.level3Code = level3Code;
    }

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name == null ? null : level1Name.trim();
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name == null ? null : level2Name.trim();
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name == null ? null : level3Name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}