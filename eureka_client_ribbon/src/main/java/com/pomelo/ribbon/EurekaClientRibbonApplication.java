package com.pomelo.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class EurekaClientRibbonApplication {

	/**
	 * @Author Mr.Jangni
	 * @Description LoadBalanced注解 RestTemplate整合ribbon 使其具备负载均衡的能力
	 * @Date 2018/12/7 23:16
	 **/
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/**
	 * @Author Mr.Jangni
	 * @Description
	 * Ribbon 是 Netflix 下的负载均衡项目，在集群中为各个客户端的通信提供支持，主要实现中间层应用程序的负载均衡，提供以下特性：
	 * * 负载均衡器，可支持插拔式的负载均衡规则
	 * * 对多种协议提供支持，例如HTTP、TCP
	 * * 集成了负载均衡功能的客户端
	 * Ribbon 可以与 Eureka 服务注册中心整合使用，并且被整合到 Spring Cloud Netflix 子项目中。Ribbon 主要有三大模块，模块说明如下：
	 * * ribbon-core：该模块为Ribbon项目的核心，主要包括负载均衡器接口定义、客户端接口定义、内置的负载均衡实现等API
	 * * ribbon-eureka：为 Eureka 客户端提供的负载君均衡实现类
	 * * ribbon-httpclient：对 Apache 的 HttpClient 进行封装，该模块提供了含有负载均衡功能的 REST 客户端
	 * Ribbon 的负载均衡器主要是与集群中的各个服务器进行通信，因此负载均衡器需要提供维护服务器IP、DNS名称等信息、根据特定逻辑在服务器列表中循环的功能，
	 * 为了实现这些功能 Ribbon 的负载均衡器提供了以下三大模块：
	 * * Rule：该组件用于处理从服务器列表中选择那个服务器实例
	 * * Ping：该组件主要用定时器来确保服务器网络可以连接
	 * * ServerList：服务器列表，可以通过静态的配置确定负载的服务器，也可以动态指定服务器列表，如果动态指定服务器列表，则会有后台线程来刷新该列表
	 * @Date 2018/12/8 11:59
	 **/
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}
}
