package com.jhr.git.first.mapper;

import com.jhr.git.first.entity.User;
import com.jhr.git.first.entity.UserCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserCondition example);

    int deleteByExample(UserCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCondition example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCondition example);

    int updateByExample(@Param("record") User record, @Param("example") UserCondition example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}