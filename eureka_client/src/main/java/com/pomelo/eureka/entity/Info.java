package com.pomelo.eureka.entity;

/**
 * @ClassName Info
 * @Description 文字
 * @Author Mr.Jangni
 * @Date 2018/12/8 20:54
 * @Version 1.0
 **/
public class Info {
    private Integer id;
    private String title;
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}