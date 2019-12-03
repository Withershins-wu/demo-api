package com.zy.dao;

import com.zy.entity.User;
import com.zy.vo.UserVo;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUser(UserVo user);

    User selectByEmail(String email);
}