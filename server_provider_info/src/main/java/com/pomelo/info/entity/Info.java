package com.pomelo.info.entity;

import javax.persistence.*;

/**
 * @ClassName Info
 * @Description 文字
 * @Author Mr.Jangni
 * @Date 2018/12/8 20:54
 * @Version 1.0
 **/
@Entity(name = "pomelo_info")
public class Info {
    @Id
    @Column(name = "id",length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title",length = 1028)
    private String title;

    @Column(name = "context",length = 1024)
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