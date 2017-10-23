package com.jhr.git.First.controller;

import com.jhr.git.First.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "Shop")
@Slf4j
public class TestController {
    @ApiOperation(value = "获取helloWorld", notes = "简单SpringMVC请求")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "HELLO WORLD222";
    }

    @ApiOperation(value = "获得A+B", notes = "根据url的classNo和url的studentName获得请求参数的字符串相加，RestFul风格的请求")
    //@ApiImplicitParams({@ApiImplicitParam(name = "classNo", value = "班级编号", required = true, dataType = "String"),})
    @RequestMapping(value = "/class/{classNo}/to/{studentName}", method = RequestMethod.GET)
    String world(@PathVariable("classNo") String classNo, @PathVariable("studentName") String studentName) {
        return classNo + "  " + studentName;
    }

    @ApiOperation(value = "用户添加", notes = "输入参数添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String addUser(@RequestBody String userStr){
        return "success";
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody String user) {
        User user1 = new User();
        user1.setId(String.valueOf(id));
        user1.setUsername(user);
        return "success";
    }

    @ApiOperation(value = "测试前端json直接转换成bean")
    @RequestMapping(value = "/lombok",method = RequestMethod.POST)
    public String lombok(@RequestBody User user,@RequestParam String token){
        // logback 使用这种方式记录日志，lombok提供了默认的toString()方法
        log.info("front send here {}",user);
        return "sout";
    }




}