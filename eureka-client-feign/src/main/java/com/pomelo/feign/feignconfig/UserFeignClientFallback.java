package com.pomelo.feign.feignconfig;

import com.pomelo.feign.entity.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserFeignClientFallback
 * @Description 服务讲解操作
 * @Author Mr.Jangni
 * @Date 2018/12/8 17:31
 * @Version 1.0
 **/
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("未名");
        user.setName("未名");
        user.setAge(0);
        return user;
    }
}