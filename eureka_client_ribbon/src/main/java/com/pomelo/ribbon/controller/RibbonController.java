package com.pomelo.ribbon.controller;

import com.pomelo.ribbon.entity.Info;
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
 * @ClassName RibbonController
 * @Description test
 * @Author Mr.Jangni
 * @Date 2018/12/8 0:43
 * @Version 1.0
 **/
@RestController
public class RibbonController {

    private static Logger logger = LoggerFactory.getLogger(RibbonController.class);
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/info/{id}")
    public Info findById(@PathVariable Integer id) {
        return restTemplate.getForObject("http://server-provider-info/info/" + id, Info.class);
    }

    @GetMapping("/port")
    public String logUserInstance() {
        ServiceInstance instance = loadBalancerClient.choose("server-provider-info");
        logger.info("{}:{}:{}", instance.getServiceId(), instance.getHost(), instance.getPort());
        return instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort();
    }
}