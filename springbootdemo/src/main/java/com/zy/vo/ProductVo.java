package com.zy.vo;

/**
 * @author zhangyan
 * @date 2018-08-09 14:59
 * @desc 商品Vo
 **/
public class ProductVo {

    private String name;
    private Integer number;
    private Byte sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }
}
