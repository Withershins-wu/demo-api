package com.zy.service.impl;

import com.github.pagehelper.PageHelper;
import com.zy.dao.PracticeMapper;
import com.zy.dao.UserPracticeMapper;
import com.zy.entity.Practice;
import com.zy.entity.UserPractice;
import com.zy.service.IPracticeService;
import com.zy.vo.PracticeHistoryAddVo;
import com.zy.vo.PracticeHistoryVo;
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

    @Resource
    private UserPracticeMapper userPracticeMapper;


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

    @Override
    public JsonResult<DataGridResult<List<Practice>>> selectLikePractice(PracticeVo vo) {
        JsonResult result = new JsonResult();
        List<Practice> list = practiceMapper.selectLikePractice(vo);
        result.setData(new DataGridResult(list));
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("success");
        return result;
    }

    @Override
    public JsonResult addPracticesHistory(PracticeHistoryAddVo vo) {
        Practice practice = practiceMapper.selectByTitle(vo.getTitle());
        if (practice == null){
            return JsonResult.fail("题目不存在！");
        }
        UserPractice userPractice = new UserPractice();
        userPractice.setUserId(vo.getUserId());
        userPractice.setPracticeId(practice.getId());
        userPractice.setStatus(vo.getStatus());
        userPracticeMapper.insertSelective(userPractice);
        return JsonResult.success("success");
    }

    @Override
    public JsonResult<DataGridResult<List<PracticeHistoryVo>>> getPracticesHistory(PracticeHistoryAddVo vo) {
        JsonResult<DataGridResult<List<PracticeHistoryVo>>> result = new JsonResult<DataGridResult<List<PracticeHistoryVo>>>();
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<PracticeHistoryVo> list = practiceMapper.selectHistoryPractices(vo);
        DataGridResult dataGridResult = new DataGridResult(list);
        result.setData(dataGridResult);
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("success");
        return result;
    }
}
