package com.pomelo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringCloudConfigClientApplication {

    @Value("${age}")
    private String age;
    @Autowired
    private HelloService helloService;
    @Value("${name}")
    private String name;
    @Value("${version}")
    private String version = "开发环境";

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return helloService.hello(name);
    }

    @RequestMapping("/test")
    public String test() {
        return "你好，我是" + name + ",年龄：" + age + "岁。当前环境：" + version;
    }

    @FeignClient(value = "helloService", fallback = HelloError.class)
    public interface HelloService {
        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        String hello(@RequestParam("name") String name);
    }

    @Component
    public class HelloError implements HelloService {
        @Override
        public String hello(String name) {
            return "hello ," + name + "! sorry ,error !";
        }
    }
}
