package com.jhr.git.first.service;

import com.jhr.git.first.entity.User;
import com.jhr.git.first.entity.UserCondition;
import com.jhr.git.first.mapper.UserAgeRecordMapper;
import com.jhr.git.first.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinhuari
 * date: 2017/12/4
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class UserService implements BusinessService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserAgeRecordMapper userAgeRecordMapper;

    public void updateAge() {
        // 添加记录
        // 修改余额
    }

    public List<User> loadUsers() {
        UserCondition condition = new UserCondition();
        return userMapper.selectByExample(condition);
    }
}
