package com.jhr.git.First.controller;

import com.jhr.git.First.domain.User;
import com.jhr.git.First.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "TestAPI", description = "user服务描述", tags = "user服务标签")
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

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
    String addUser(@RequestBody String userStr) {
        return "success";
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody String user) {
        User user1 = new User();
        user1.setId(String.valueOf(id));
        user1.setUsername(user);
        return "success";
    }

    @ApiOperation(value = "测试前端json直接转换成bean")
    @RequestMapping(value = "/lombok", method = RequestMethod.POST)
    public String lombok(@RequestBody User user, @RequestParam String token) {
        // logback 使用这种方式记录日志，lombok提供了默认的toString()方法
        log.info("front send here {}", user);
        return "sout";
    }

    @ApiOperation(value = "用户列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return testService.listUser();
    }

    @ApiOperation(value = "数值查询", notes = "测试两个service方法参数都为空，都缓存，都指定同一个value")
    @RequestMapping(value = "/listInt", method = RequestMethod.GET)
    public List<Integer> listInt() {
        return testService.listInt();
    }

    @ApiOperation(value = "根据用户名查询")
    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public User getUserByName(@RequestParam String username) {
        return testService.getUserByName(username);
    }


}