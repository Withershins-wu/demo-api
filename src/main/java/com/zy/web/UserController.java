package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import com.zy.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("用户相关")
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

}
