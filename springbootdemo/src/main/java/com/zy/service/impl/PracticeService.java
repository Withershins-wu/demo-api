package com.zy.service.impl;

import com.github.pagehelper.PageHelper;
import com.zy.dao.PracticeMapper;
import com.zy.entity.Practice;
import com.zy.service.IPracticeService;
import com.zy.vo.PageVo;
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
    public List<Practice> selectAllPractice(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<Practice> list = practiceMapper.selectAll();
        return list;
    }
}
