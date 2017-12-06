/*
 * Copyright (c) 2017. SheIn
 * 南京领添信息技术有限公司
 * http://shein.com
 * All rights reserved.
 */

package com.jhr.git.first.service;

import org.junit.Test;

/**
 * @author jinhuari
 * date: 2017/12/6
 */
public class TestFinally {

    @Test
    public void test1() {
        System.out.println("return value of getValue(): " + getValue());
    }

    public static int getValue() {
        int i = 1;
        try {
            return i;
        } finally {
            i++;
            //return i;
        }
    }

    @Test
    public void test2(){
        System.out.println("return:"+getStrValue());
    }

    public static String getStrValue(){

        StringBuilder stringBuilder = new StringBuilder("init");
        try {
            System.out.println("do try");
            stringBuilder.append(" try ");
            return stringBuilder.toString();
        }finally {
            stringBuilder.append(" finally ");
            System.out.println("do finally");
        }
    }

}
