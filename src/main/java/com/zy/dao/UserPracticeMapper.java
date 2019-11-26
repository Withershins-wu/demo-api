package com.zy.dao;

import com.zy.entity.UserPractice;

public interface UserPracticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPractice record);

    int insertSelective(UserPractice record);

    UserPractice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPractice record);

    int updateByPrimaryKey(UserPractice record);
}