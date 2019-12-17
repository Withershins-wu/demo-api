package com.zy.service.impl;

import com.zy.service.Person;

/**
 * @author zhangyan
 * @date 2019-12-16 16:24
 * @desc
 **/
public class Student implements Person {

    private String name;

    @Override
    public void giveTask() {
        System.out.println(name + "交作业");
    }

    public Student(String name) {
        this.name = name;
    }
}
