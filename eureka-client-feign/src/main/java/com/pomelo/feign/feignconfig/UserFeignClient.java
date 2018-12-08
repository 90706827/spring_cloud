package com.pomelo.feign.feignconfig;

import com.pomelo.feign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserFeignClient
 * @Description feign
 * @Author Mr.Jangni
 * @Date 2018/12/8 12:21
 * @Version 1.0
 **/
public interface UserFeignClient {

    @RequestLine("GET /user/{id}")
    public User findById(@Param("id") Integer id);
}