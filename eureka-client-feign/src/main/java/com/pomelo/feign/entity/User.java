package com.pomelo.feign.entity;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户类
 * @Author Mr.Jangni
 * @Date 2018/12/7 23:39
 * @Version 1.0
 **/
public class User implements Serializable {

    private Integer age;
    private Integer id;
    private String name;
    private String password;
    private String username;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}