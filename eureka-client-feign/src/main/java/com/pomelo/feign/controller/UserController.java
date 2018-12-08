package com.pomelo.feign.controller;

import com.pomelo.feign.entity.User;
import com.pomelo.feign.feignconfig.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @ClassName UserController
 * @Description feignTest
 * @Author Mr.Jangni
 * @Date 2018/12/8 12:27
 * @Version 1.0
 **/

@Import(FeignClientsConfiguration.class)
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    private UserFeignClient userFeignClient;
    private UserFeignClient adminUserFeignClient;

    @Autowired
    public UserController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        // 这边的decoder、encoder、client、contract，可以debug看看是什么实例。
        this.userFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "password1"))
                .target(UserFeignClient.class, "http://server-provider-user/");
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2"))
                .target(UserFeignClient.class,"http://server-provider-user/");
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userFeignClient.findById(id);
    }
}