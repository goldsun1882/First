package com.jhr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * author: jinhuari
 * date: 2017/10/23
 * description: 测试java8的lambda
 */
public class Java8Test {

    @Test
    public void test() {
        // java 8 runnable
        new Thread(() -> System.out.println("java 8 runnable")).start();
        // java8 foreach
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        // java8 list
        //features.forEach(System.out::println);
        //
        testPredicate();

        // test filter
        testFilter();
        // test performance
        testPerformance();
    }

    private void testPerformance() {
        long a = System.currentTimeMillis();
        System.out.println("prepare data begin====");
        List<Integer> src = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            src.add(i);
        }
        long b = System.currentTimeMillis();
        System.out.println("prepare data end:" + (b - a));
        runForeach(src);
        runFor(src);
    }

    private void runFor(List<Integer> src) {
        System.out.println("run lambda begin====");
        long a = System.currentTimeMillis();
        double result = 0L;
        result = src.stream().mapToInt(t -> t).sum();
        System.out.println("result==" + result);
        long b = System.currentTimeMillis();
        System.out.println("run lambda end ,use " + (b - a));

    }

    private void runForeach(List<Integer> src) {
        System.out.println("run foreach begin====");
        long a = System.currentTimeMillis();
        double result = 0L;
        for (int i : src) {
            result += i;
            //System.out.print(i);
        }
        System.out.println("result==" + result);
        long b = System.currentTimeMillis();
        System.out.println("run foreach end ,use " + (b - a));
    }

    private void testFilter() {
        System.out.println("test filter ====");
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        List<String> now = languages.stream().filter(v -> v.startsWith("J")).collect(Collectors.toList());
        now.forEach(v -> System.out.println(v));
    }

    private void testPredicate() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        //filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        //filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, str -> true);

        System.out.println("Print no language : ");
        filter(languages, str -> false);

        System.out.println("Print language whose length greater than 4:");
        // filter(languages, (str)->str.length() > 4);
    }

    public void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    @Test
    public void testOptional() {
        Optional<User> user = null;
        String name = getUserName(user);
        System.out.println(name);
    }

    public String getUserName(Optional<User> user) {
        return user.map(user1 -> user1.getId())
                .map(id -> id.toUpperCase())
                .orElse(null);
    }

    class User {
        private String userName;
        private String id;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}


