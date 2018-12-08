package com.pomelo.feign.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfiguration
 * @Description Feign配置类
 * @Author Mr.Jangni
 * @Date 2018/12/8 17:54
 * @Version 1.0
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}