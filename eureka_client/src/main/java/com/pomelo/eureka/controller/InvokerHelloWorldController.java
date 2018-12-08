package com.pomelo.eureka.controller;

import com.pomelo.eureka.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName InvokerHelloWorldController
 * @Description rest 测试类
 * @Author Mr.Jangni
 * @Date 2018/12/5 20:20
 * @Version 1.0
 **/
@RestController
public class InvokerHelloWorldController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Author Mr.Jangni
     * @Description required 设置false，如果传入空值会报错,设置true，如果传入空值会赋值null
     * @Date 2018/12/5 20:23
     **/
    @RequestMapping(name = "/info/{id}", method = RequestMethod.GET)
    public Info invokerSpack(@PathVariable("id") Integer id) throws UnsupportedEncodingException {

        return restTemplate.getForObject("http://server-provider-info/info/" + id, Info.class);
    }

}