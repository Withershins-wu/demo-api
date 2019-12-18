package com.zy.web;

import java.util.*;

/**
 * @author zhangyan
 * @date 2019-12-17 14:04
 * @desc
 * 1、Collection（单列集合）
 *  a、list接口（有序、有索引、可以重复）
 *      1)ArrayList：实现自List接口。
 *                   底层是以数组的形式实现，可以按照索引取出对应位置的元素，允许元素为null。
 *                   不是线程安全的。
 *                   查找速度快，插入、删除慢。
 *      2)LinkedList：实现在List接口。
 *                    底层是以双向链表的形式实现。
 *                    所以插入，删除快，但是查找慢。
 *                    不是线程安全的。
 *  b、set接口（无序、无索引、不可重复）
 *      1)hashSet：底层是一个数组，但是元素的位置和元素的取值不存在确定的关系，而是将元素进行Hash运算之后的位置。
 *                 这样做是为了增加查询的速度。
 *                 index = hash(value)。不
 *                 是线程安全。
 *
 * 2、Map（双列集合）
 *  a、hashMap
 **/
public class Collections {
    public static void main(String[] args) {
        // 遍历list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer a = iterator.next();
//            System.out.println(a);
        }

        // 遍历map(面试有问到)
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");
        map.put("key4", "value1");
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
