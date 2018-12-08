package com.pomelo.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbomConfiguration
 * @Description ribbon策略配置
 * @Author Mr.Jangni
 * @Date 2018/12/8 11:29
 * @Version 1.0
 **/
@Configuration
public class RibbonConfiguration {

    /**
     * @Author Mr.Jangni
     * @Description 负载策略
     * @Date 2018/12/8 11:40
     **/
    @Bean
    public IRule ribbonRule(){

        /**
         * @Author Mr.Jangni
         * @Description 随机策略
         * @Date 2018/12/8 11:49
         **/
//        return new RandomRule();
        /**
         * @Author Mr.Jangni
         * @Description 轮训策略 框架默认此策略
         * @Date 2018/12/8 11:49
         **/
        return new RoundRobinRule();
    }

}