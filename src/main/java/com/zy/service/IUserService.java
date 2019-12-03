package com.zy.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.vo.base.JsonResult;
import com.zy.vo.UserVo;

/**
 * @author zhangyan
 * @date 2018-09-05 18:06
 * @desc 用户
 **/
public interface IUserService {
    JsonResult<JSONObject> addUser(UserVo user);

    JsonResult selectByUser(UserVo user);
}
