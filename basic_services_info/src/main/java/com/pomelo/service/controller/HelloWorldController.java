package com.pomelo.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Description 基础信息测试
 * @Author Mr.Jangni
 * @Date 2018/12/5 20:38
 * @Version 1.0
 **/
@RestController
public class HelloWorldController {

    @RequestMapping(name = "speak", method = RequestMethod.GET)
    public String speak(@RequestParam(value = "body", required = false) String body) {
        if (body == null || "".equals(body)) {
            return "HELLO WORLD";
        }
        return "speak : " + body;
    }

}