package com.zy.dao;


import com.zy.entity.Practice;

import java.util.List;

public interface PracticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Practice record);

    int insertSelective(Practice record);

    Practice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);

    List<Practice> selectAll();
}