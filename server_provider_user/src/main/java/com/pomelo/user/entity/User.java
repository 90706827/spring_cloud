package com.pomelo.user.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户类
 * @Author Mr.Jangni
 * @Date 2018/12/7 23:39
 * @Version 1.0
 **/
@Entity(name = "pomelo_user")
public class User implements Serializable {

    @Id
    @Column(name = "id",length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username",length = 64)
    private String username;

    @Column(name = "password",length = 128)
    private String password;

    @Column(name = "name",length = 64)
    private String name;

    @Column(name = "age",length = 11)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}