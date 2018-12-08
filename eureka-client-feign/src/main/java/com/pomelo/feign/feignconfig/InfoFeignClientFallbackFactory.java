package com.pomelo.feign.feignconfig;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.pomelo.feign.entity.Info;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName InfoFeignClientFallbackFactory
 * @Description
 * @Author Mr.Jangni
 * @Date 2018/12/8 23:09
 * @Version 1.0
 **/
@Component
public class InfoFeignClientFallbackFactory implements FallbackFactory<InfoFeignClient> {

    @Override
    public InfoFeignClient create(Throwable throwable) {
        return new InfoFeignClient() {
            @Override
            public Info getInfo(Integer id) {
                Info info = new Info();
                //根据不用的异常相应不同的结果
                if (throwable instanceof HystrixTimeoutException) {
                    info.setTitle("ERROR:HystrixTimeoutException");
                }
                System.out.println(throwable.toString());
                info.setId(id);
                info.setContext("feign fallback");
                return info;
            }
        };
    }
}