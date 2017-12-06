package com.jhr.git.first.entity;

public class UserAgeRecord {
    private Integer id;

    private String userName;

    private Integer ageBefore;

    private Integer ageAfter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAgeBefore() {
        return ageBefore;
    }

    public void setAgeBefore(Integer ageBefore) {
        this.ageBefore = ageBefore;
    }

    public Integer getAgeAfter() {
        return ageAfter;
    }

    public void setAgeAfter(Integer ageAfter) {
        this.ageAfter = ageAfter;
    }
}