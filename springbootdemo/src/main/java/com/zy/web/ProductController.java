package com.zy.web;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.Product;
import com.zy.service.IProductService;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import com.zy.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;
    /**
     * 获取商品
     * @return
     */
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public JsonResult<Product> getHello(HttpServletRequest request, @RequestParam Long pid){
        JsonResult<Product> result = new JsonResult<Product>();
//        result = productService.getProduct(pid);
        return JsonResult.success("success");
    }


    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public JsonResult addProduct(HttpServletRequest request, @RequestBody ProductVo vo){
        JsonResult result = productService.addProduct(vo);
        return result;
    }

    /**
     * 上传图片
     * @param img //图片base64编码
     * @return{
     *         "status": 200,
     *         "msg": ""
     *         "data":{key:"" //七牛返回的id}
     *         }
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImgQiniu", method = RequestMethod.POST)
    public JsonResult<JSONObject> uploadImgQiniu(HttpServletRequest request, @RequestBody String img) throws Exception {
        return userService.uploadImgQiniu(img);
    }
}
