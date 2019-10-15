package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import com.zy.service.IProduceService;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@RestController()
@RequestMapping("/user")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IProduceService produceService;
    /**
     * 获取商品
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<JSONObject> registerUser(HttpServletRequest request, @RequestBody User user){
        JsonResult<JSONObject> result = new JsonResult<JSONObject>();
        result = userService.addUser(user);
        return result;
    }

    @Test
    public void contextLoads(){
        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<2; i++){
            produceService.sendMessage(destination, "myname is chhliu!!!");
        }
    }
}
