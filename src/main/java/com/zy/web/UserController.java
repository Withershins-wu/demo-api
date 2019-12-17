package com.zy.web;

import com.zy.service.IUserService;
import com.zy.utils.ToolUtil;
import com.zy.vo.base.JsonResult;
import com.zy.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.security.PrivateKey;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@Api(tags = "用户相关")
@RestController()
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 登录
     * @return
     */
    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody UserVo user){
        return userService.selectByUser(user);
    }


    /**
     * 注册
     * @return
     */
    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody UserVo user){
        return userService.addUser(user);
    }

    public static void main(String[] args) throws InterruptedException {
        ToolUtil toolUtil = new ToolUtil();
        for (int i=0; i< 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        toolUtil.setA(toolUtil.getA() - 1);
                    }

                }
            }).start();
            if (i==99){
                System.out.println("99");
            }
        }
        Thread.sleep(6000);
        System.out.println(toolUtil.getA());
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
