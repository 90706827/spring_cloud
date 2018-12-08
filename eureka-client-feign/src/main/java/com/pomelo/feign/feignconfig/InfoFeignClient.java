package com.pomelo.feign.feignconfig;

import com.pomelo.feign.entity.Info;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @ClassName InfoFeignClient
 * @Description FeignClient
 * @Author Mr.Jangni
 * @Date 2018/12/8 22:51
 * @Version 1.0
 **/
@FeignClient(name = "server-provider-info",
        fallback = InfoFeignClientFallback.class,
        //fallback 存在则 fallbackFactory 不会起作用
        fallbackFactory = InfoFeignClientFallbackFactory.class)
public interface InfoFeignClient {

    @RequestLine("GET /info/{id}")
    public Info getInfo(@Param("id") Integer id);
}