package com.zy.service.impl;

import com.zy.service.Person;

/**
 * @author zhangyan
 * @date 2019-12-16 16:27
 * @desc 代理类
 **/
public class ProxyStu implements Person {

    Student stu;

    public ProxyStu(Person stu){
        if (stu.getClass() == Student.class){
            this.stu = (Student) stu;
        }

    }

    @Override
    public void giveTask() {
        System.out.println("代理执行方法前");
        stu.giveTask();
        System.out.println("代理执行方法后");
    }
}
