package com.zy.dao;


import com.zy.entity.Practice;
import com.zy.vo.PracticeHistoryAddVo;
import com.zy.vo.PracticeHistoryVo;
import com.zy.vo.PracticeVo;

import java.util.List;

public interface PracticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Practice record);

    int insertSelective(Practice record);

    Practice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);

    List<Practice> selectByParams(PracticeVo vo);

    List<Practice> selectLikePractice(PracticeVo vo);

    Practice selectByTitle(String title);

    List<PracticeHistoryVo> selectHistoryPractices(PracticeHistoryAddVo vo);
}