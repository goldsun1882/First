package com.jhr.git.first.mapper;

import com.jhr.git.first.vo.UserReq;
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
    private List<UserReq> list = new ArrayList<>();

    private TestDAO(){
        for (int i = 0; i < 109; i++) {
            UserReq userReq = new UserReq();
            userReq.setId("userReq" + i);
            userReq.setUserName("userName" + i);
            userReq.setPassword("9999");
            list.add(userReq);
        }
    }

    public List<UserReq> listUser() {
        log.info("get user from db");
        return list;
    }

    public UserReq getUserByName(String username) {
        log.info("get user by name from db");
        Optional<UserReq> p = list.stream().filter(userReq -> userReq.getUserName().equals(username)).findFirst();
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
