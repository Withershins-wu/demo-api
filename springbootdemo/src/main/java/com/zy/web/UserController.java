package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
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
public class UserController {

    @Resource
    private IUserService userService;


    @Resource // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsTemplate jmsTemplate;
    /**
     * 获取商品
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<JSONObject> registerUser(HttpServletRequest request, @RequestBody User user){
        JsonResult<JSONObject> result = new JsonResult<JSONObject>();
//        result = userService.addUser(user);
        return JsonResult.success("success");
    }
}
