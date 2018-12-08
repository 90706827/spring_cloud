package com.pomelo.feign.feignconfig;

import com.pomelo.feign.entity.Info;
import org.springframework.stereotype.Component;

/**
 * @ClassName InfoFeignClientFallback
 * @Description info
 * @Author Mr.Jangni
 * @Date 2018/12/8 22:52
 * @Version 1.0
 **/
@Component
public class InfoFeignClientFallback implements InfoFeignClient {

    @Override
    public Info getInfo(Integer id) {
        Info info = new Info();
        info.setId(id);
        info.setTitle("fallbook");
        info.setContext("feign fall book");
        return info;
    }
}