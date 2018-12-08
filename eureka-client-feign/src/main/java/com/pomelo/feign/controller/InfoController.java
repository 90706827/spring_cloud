package com.pomelo.feign.controller;

import com.pomelo.feign.entity.Info;
import com.pomelo.feign.feignconfig.InfoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName InfoController
 * @Description info
 * @Author Mr.Jangni
 * @Date 2018/12/8 22:50
 * @Version 1.0
 **/
@RestController
public class InfoController {

    @Autowired
    private InfoFeignClient infoFeignClient;

    @GetMapping("/info/{id}")
    public Info getInfo(@PathVariable("id") Integer id) {
        return infoFeignClient.getInfo(id);
    }
}