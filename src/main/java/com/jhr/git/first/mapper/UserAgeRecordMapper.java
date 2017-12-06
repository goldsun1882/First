package com.jhr.git.first.mapper;

import java.util.List;

import com.jhr.git.first.entity.UserAgeRecord;
import com.jhr.git.first.entity.UserAgeRecordCondition;
import org.apache.ibatis.annotations.Param;

public interface UserAgeRecordMapper {
    int countByExample(UserAgeRecordCondition example);

    int deleteByExample(UserAgeRecordCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAgeRecord record);

    int insertSelective(UserAgeRecord record);

    List<UserAgeRecord> selectByExample(UserAgeRecordCondition example);

    UserAgeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAgeRecord record, @Param("example") UserAgeRecordCondition example);

    int updateByExample(@Param("record") UserAgeRecord record, @Param("example") UserAgeRecordCondition example);

    int updateByPrimaryKeySelective(UserAgeRecord record);

    int updateByPrimaryKey(UserAgeRecord record);
}