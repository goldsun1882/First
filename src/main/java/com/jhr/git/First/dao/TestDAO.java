package com.jhr.git.First.dao;

import com.jhr.git.First.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * author: jinhuari
 * date: 2017/10/24
 * description:
 */
@Component
@Slf4j
public class TestDAO {
    private List<User> list = new ArrayList<>();

    private TestDAO(){
        for (int i = 0; i < 109; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setUsername("userName" + i);
            user.setPassword("9999");
            list.add(user);
        }
    }

    public List<User> listUser() {
        log.info("get user from db");
        return list;
    }

    public User getUserByName(String username) {
        log.info("get user by name from db");
        Optional<User> p = list.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        return p.orElse(null);
    }

    public List<Integer> listInt() {
        log.info("get list from db");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 109; i++) {
            list.add(i);
        }
        return list;
    }
}
