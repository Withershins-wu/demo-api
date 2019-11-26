package com.zy.service;

import com.zy.entity.Practice;
import com.zy.vo.PageVo;

import java.util.List;

/**
 * @author zhangyan
 * @date 2018-08-09 14:52
 * @desc 商品接口
 **/
public interface IPracticeService {
    List<Practice> selectAllPractice(PageVo pageVo);
//    JsonResult addProduct(ProductVo vo);
//
//    JsonResult<Product> getProduct(Long pid);
}
