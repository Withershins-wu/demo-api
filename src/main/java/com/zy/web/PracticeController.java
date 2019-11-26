package com.zy.web;

import com.zy.entity.Practice;
import com.zy.entity.Product;
import com.zy.service.IPracticeService;
import com.zy.service.IUserService;
import com.zy.vo.JsonResult;
import com.zy.vo.PageVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018-08-06 16:41
 * @desc hello
 **/
@Controller()
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
    @RequestMapping(value = "/getPractices", method = RequestMethod.GET)
    public String getPractices(Model model){
        PageVo vo = new PageVo();
        vo.setPageNum(1);
        vo.setPageSize(10);
        List<Practice> list = practiceService.selectAllPractice(vo);
        model.addAttribute("practiceList", list);
        return "practicebank";
    }

//
//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public JsonResult addProduct(HttpServletRequest request, @RequestBody ProductVo vo){
//        JsonResult result = productService.addProduct(vo);
//        return result;
//    }

}
