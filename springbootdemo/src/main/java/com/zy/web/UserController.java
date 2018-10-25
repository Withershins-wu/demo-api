package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.Product;
import com.zy.entity.User;
import com.zy.service.IProductService;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import com.zy.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
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


}
