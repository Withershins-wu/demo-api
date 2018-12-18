package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.dao.UserMapper;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.utils.ToolUtil;
import com.zy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyan
 * @date 2018-09-05 18:07
 * @desc
 **/
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redis;

    @Override
    public JsonResult<JSONObject> addUser(User user) {
        JsonResult result = new JsonResult();
        userMapper.insert(user);
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("注册成功");
        return result;
    }

    @Override
    public JsonResult<JSONObject> uploadImgQiniu(String img) throws Exception {
        JsonResult<JSONObject> result = new JsonResult<>();
        result.setCode(JsonResult.FAIL);
        JSONObject data = new JSONObject();
        data.put("key", ToolUtil.uploadAppPicture(img, redis));

        result.setCode(JsonResult.SUCCESS);
        result.setData(data);
        result.setMsg("图片上传成功");
        return result;
    }
}
