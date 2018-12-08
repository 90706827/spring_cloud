package com.pomelo.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pomelo.hystrix.entity.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName InfoController
 * @Description info
 * @Author Mr.Jangni
 * @Date 2018/12/8 22:00
 * @Version 1.0
 **/

@RestController
public class InfoController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getInfoFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000")
    },threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "1"),
            @HystrixProperty(name = "maxQueueSize",value = "10")
    })
    @GetMapping("/info/{id}")
    public Info getInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://server-provider-info/info/" + id, Info.class);
    }

    public Info getInfoFallback(Integer id) {
        Info info = new Info();
        info.setId(id);
        info.setTitle("未知");
        info.setContext("未知");
        return info;
    }

    @GetMapping("/port")
    public String port() {
        ServiceInstance instance = loadBalancerClient.choose("server-provider-info");
        return "ServiceId:[" + instance.getServiceId() + "],Host:[" + instance.getHost() + "],Port:[" + instance.getPort() + "]";
    }


}