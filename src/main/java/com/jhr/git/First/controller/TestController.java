package com.jhr.git.First.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "Shop")
public class TestController {
    @ApiOperation(value = "获取helloWorld", notes = "简单SpringMVC请求")
    @RequestMapping("/")
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
        return "success";
    }


}