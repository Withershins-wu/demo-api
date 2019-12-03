package com.zy.web;

import com.zy.entity.Practice;
import com.zy.service.IPracticeService;
import com.zy.service.IUserService;
import com.zy.vo.base.DataGridResult;
import com.zy.vo.base.JsonResult;
import com.zy.vo.PracticeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@Api(tags = "题库")
@RestController()
@RequestMapping("/practice")
public class PracticeController {

    @Resource
    private IPracticeService practiceService;
    @Resource
    private IUserService userService;

    /**
     * 获取商品
     * @return
     */
    @ApiOperation("根据条件获取题目")
    @RequestMapping(value = "/getPractices", method = RequestMethod.POST)
    public JsonResult<DataGridResult<List<Practice>>> getPractices(@RequestBody PracticeVo vo){
        return practiceService.selectAllPractice(vo);

    }


//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public JsonResult addProduct(HttpServletRequest request, @RequestBody ProductVo vo){
//        JsonResult result = productService.addProduct(vo);
//        return result;
//    }

}
