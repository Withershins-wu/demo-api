package com.zy.web;

import com.zy.utils.ToolUtil;

/**
 * @author zhangyan
 * @date 2019-12-17 16:43
 * @desc
 **/
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ToolUtil toolUtil = new ToolUtil();
        for (int i=0; i< 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    toolUtil.del();
                }
            }).start();
            if (i==999){
                System.out.println("99");
            }
        }
        Thread.sleep(2000);
        System.out.println(ToolUtil.a);
//        Jedis jedis = new Jedis();
//        jedis.set("a","100");
//        for (int i=0; i< 100; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    jedis.decr("a");
//                }
//            }).start();
//        }
//        Thread.sleep(2000);
//        System.out.println(jedis.get("a"));

    }
}
