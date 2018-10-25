package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.dao.UserMapper;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangyan
 * @date 2018-09-05 18:07
 * @desc
 **/
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public JsonResult<JSONObject> addUser(User user) {
        JsonResult result = new JsonResult();
        userMapper.insert(user);
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("注册成功");
        return result;
    }
}
