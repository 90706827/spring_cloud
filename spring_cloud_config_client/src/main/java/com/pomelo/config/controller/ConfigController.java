package com.pomelo.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description 测试加载config server配置   @RefreshScope 手动刷新git配置
 * @Author Mr.Jangni
 * @Date 2018/12/6 21:12
 * @Version 1.0
 **/
@RestController
@RefreshScope
public class ConfigController {

    @Value("${age}")
    private String age;

    @Value("${name}")
    private String name;

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/userConfig", method = RequestMethod.GET)
    public String helloUser() {
        String info = "helle " + name + " old " + age + " version " + version;
        System.out.println(info);
        return info;
    }

}