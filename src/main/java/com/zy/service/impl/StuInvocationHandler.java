package com.zy.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangyan
 * @date 2019-12-16 16:40
 * @desc
 **/
public class StuInvocationHandler<T> implements InvocationHandler {

    T tar;

    public StuInvocationHandler(T tar){
        this.tar = tar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行了" +method.getName() + "方法");
        Object invoke = method.invoke(tar, args);
        return invoke;
    }
}
