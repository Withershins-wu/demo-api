package com.zy.service;

import com.zy.entity.Practice;
import com.zy.vo.PracticeHistoryAddVo;
import com.zy.vo.PracticeHistoryVo;
import com.zy.vo.PracticeVo;
import com.zy.vo.base.DataGridResult;
import com.zy.vo.base.JsonResult;

import java.util.List;

/**
 * @author zhangyan
 * @date 2018-08-09 14:52
 * @desc 商品接口
 **/
public interface IPracticeService {
    JsonResult<DataGridResult<List<Practice>>> selectAllPractice(PracticeVo vo);

    JsonResult<DataGridResult<List<Practice>>> selectLikePractice(PracticeVo vo);

    JsonResult addPracticesHistory(PracticeHistoryAddVo vo);

    JsonResult<DataGridResult<List<PracticeHistoryVo>>> getPracticesHistory(PracticeHistoryAddVo vo);

    JsonResult<List<Practice>> getRecommendPractices(Integer userId);
//    JsonResult addProduct(ProductVo vo);
//
//    JsonResult<Product> getProduct(Long pid);
}
