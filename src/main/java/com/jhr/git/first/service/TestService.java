package com.jhr.git.first.service;

import com.jhr.git.first.vo.UserReq;
import com.jhr.git.first.mapper.TestDAO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: jinhuari
 * date: 2017/10/24
 * description:
 * 1. 同一个value上不允许有相同的key，即参数名相同的两个方法，大概存储格式应该是<value,<param+param,return>>。如无参数，key为0
 * 2. CacheEvict 只在删除的时候使用，用途用来清缓存
 * 3. CachePut 用来更新缓存，update时使用
 * 4. Cacheable 用来指定是否使用缓存，将该方法的返回值放入缓存中
 */
@Service
public class TestService {
    @Resource
    private TestDAO testDAO;

    @Cacheable(value = "accountCache")
    public List<UserReq> listUser() {
        return testDAO.listUser();
    }

    @Cacheable(value = "intCache")
    public List<Integer> listInt() {
        return testDAO.listInt();
    }

    @Cacheable(value = "accountCache")
    public UserReq getUserByName(String username) {
        return testDAO.getUserByName(username);
    }

    public void addDevFunction(){
        System.out.println("this is dev branch");
    }
}
