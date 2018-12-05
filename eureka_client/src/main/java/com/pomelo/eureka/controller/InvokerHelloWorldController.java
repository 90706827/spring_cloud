package com.pomelo.eureka.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    @RequestMapping(name = "speak",method = RequestMethod.GET)
    public String invokerSpack(@RequestParam(value = "body",required = false)String body) throws UnsupportedEncodingException {
        String encodeBody = "";
        if(body!=null){
            encodeBody= "?body="+ URLEncoder.encode(body,"utf-8");
        }
        return  restTemplate.getForObject("http://basic-service-info/speak"+encodeBody,String.class);
    }

}