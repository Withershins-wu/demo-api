package com.zy.web;

import com.zy.service.Person;
import com.zy.service.impl.ProxyStu;
import com.zy.service.impl.StuInvocationHandler;
import com.zy.service.impl.Student;

import java.lang.reflect.Proxy;

/**
 * @author zhangyan
 * @date 2019-12-16 16:22
 * @desc
 **/
public class DongTaiDaiLiTest {
    public static void main(String[] args) {
        // 生成学生
        Student student = new Student("张岩");
        // 静态代理
//        ProxyStu proxyStu = new ProxyStu(student);
//        proxyStu.giveTask();
        // 动态代理
        // 创建代理类
        StuInvocationHandler handler = new StuInvocationHandler(student);
        // 开始代理(生成班长)
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        proxy.giveTask();
    }
}
