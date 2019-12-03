package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.dao.UserMapper;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.vo.base.JsonResult;
import com.zy.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhangyan
 * @date 2018-09-05 18:07
 * @desc
 **/
@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public JsonResult<JSONObject> addUser(UserVo user) {
        JsonResult result = new JsonResult();
        User userTemp = userMapper.selectByEmail(user.getEmail());
        if (userTemp != null){
            return JsonResult.fail("该邮箱已经被注册");
        }
        if (StringUtils.isBlank(user.getPwd()) || StringUtils.isBlank(user.getRePwd()) || !user.getPwd().equals(user.getRePwd())){
            return JsonResult.fail("两次密码不一致");
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setCreateTime(new Date());
        userMapper.insertSelective(newUser);
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("注册成功");
        return result;
    }

    @Override
    public JsonResult selectByUser(UserVo user) {
        JsonResult result = new JsonResult();
        User uu = userMapper.selectByUser(user);
        if (uu == null){
            return JsonResult.fail("用户名或密码错误");
        } else {
            result.setData(uu);
            return JsonResult.success("登录成功");
        }
    }

}
