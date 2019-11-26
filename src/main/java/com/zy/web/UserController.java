package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import com.zy.vo.UserVo;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@Controller()
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 首页--登录
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody User user){
        return userService.selectByUser(user);
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    /**
     * 注册
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody UserVo user){
        return userService.addUser(user);
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/toPracticeBank", method = RequestMethod.GET)
    public String toPracticeBank(){
        return "practiceBank";
    }

}
