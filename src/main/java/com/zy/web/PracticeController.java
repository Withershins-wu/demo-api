package com.zy.web;

import com.zy.entity.Practice;
import com.zy.service.IPracticeService;
import com.zy.service.IUserService;
import com.zy.vo.PracticeHistoryAddVo;
import com.zy.vo.PracticeHistoryVo;
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


    @ApiOperation("根据条件获取题目")
    @RequestMapping(value = "/getPractices", method = RequestMethod.POST)
    public JsonResult<DataGridResult<List<Practice>>> getPractices(@RequestBody PracticeVo vo){
        return practiceService.selectAllPractice(vo);

    }

    @ApiOperation("根据题目名获取相似题目")
    @RequestMapping(value = "/getLikePractices", method = RequestMethod.POST)
    public JsonResult<DataGridResult<List<Practice>>> getLikePractices(@RequestBody PracticeVo vo){
        return practiceService.selectLikePractice(vo);
    }

    @ApiOperation("添加历史联系记录")
    @RequestMapping(value = "/addPracticesHistory", method = RequestMethod.POST)
    public JsonResult addPracticesHistory(@RequestBody PracticeHistoryAddVo vo){
        return practiceService.addPracticesHistory(vo);
    }

    @ApiOperation("获取历史联系记录")
    @RequestMapping(value = "/addPracticesHistory", method = RequestMethod.POST)
    public JsonResult<DataGridResult<List<PracticeHistoryVo>>> getPracticesHistory(@RequestBody PracticeHistoryAddVo vo){
        return practiceService.getPracticesHistory(vo);
    }



//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public JsonResult addProduct(HttpServletRequest request, @RequestBody ProductVo vo){
//        JsonResult result = productService.addProduct(vo);
//        return result;
//    }

}
