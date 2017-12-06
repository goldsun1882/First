package com.jhr.git.first.service;

import com.jhr.git.first.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author jinhuari
 * date: 2017/12/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testUpdateAge() {
        userService.updateAge();
    }

    @Test
    public void getUsers() {
        List<User> list = userService.loadUsers();
        System.out.println(list);
    }
}
