package com.jhr.git.first.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author jinhuari
 * date: 2017/12/6
 */
public class TestAspect {
    @Pointcut(value = "execution(com.jhr.**()) && args(param) &&" +
            "@target(org.springframework.stereotype.Service)",argNames = "param")
    public void pointCut(String param){

    }
}
