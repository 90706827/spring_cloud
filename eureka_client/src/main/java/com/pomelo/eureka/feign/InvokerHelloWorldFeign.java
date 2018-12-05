package com.pomelo.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName InvokerHelloWorldFeign
 * @Description Feign
 * @Author Mr.Jangni
 * @Date 2018/12/5 21:41
 * @Version 1.0
 **/
@FeignClient(name = "basic-service-info")
public interface InvokerHelloWorldFeign {

    @RequestMapping(value = "/speak",method = RequestMethod.GET)
    public String speak(@RequestParam(value = "body",required = false)String body);
}