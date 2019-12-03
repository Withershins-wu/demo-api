package com.zy.service.impl;

import com.github.pagehelper.PageHelper;
import com.zy.dao.PracticeMapper;
import com.zy.entity.Practice;
import com.zy.service.IPracticeService;
import com.zy.vo.PracticeVo;
import com.zy.vo.base.DataGridResult;
import com.zy.vo.base.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018-08-09 14:54
 * @desc 商品实现类
 **/
@Service
public class PracticeService implements IPracticeService {

    @Resource
    private PracticeMapper practiceMapper;


    @Override
    public JsonResult<DataGridResult<List<Practice>>> selectAllPractice(PracticeVo vo) {
        JsonResult<DataGridResult<List<Practice>>> result = new JsonResult<DataGridResult<List<Practice>>>();
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<Practice> list = practiceMapper.selectByParams(vo);
        DataGridResult dataGridResult = new DataGridResult(list);
        result.setData(dataGridResult);
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("success");
        return result;
    }
}
