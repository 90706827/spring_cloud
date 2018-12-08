package com.pomelo.eureka.feign;

import com.pomelo.eureka.entity.Info;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName InvokerHelloWorldFeign
 * @Description Feign
 * @Author Mr.Jangni
 * @Date 2018/12/5 21:41
 * @Version 1.0
 **/
@FeignClient(name = "server-provider-info")
public interface InvokerHelloWorldFeign {

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public Info speak(@PathVariable("id") Integer id);
}