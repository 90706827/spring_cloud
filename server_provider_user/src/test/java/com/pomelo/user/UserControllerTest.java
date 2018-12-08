package com.pomelo.user;

import com.pomelo.user.entity.User;
import com.pomelo.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserControllerTest
 * @Description test
 * @Author Mr.Jangni
 * @Date 2018/12/7 23:52
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("pomelo");
        user.setPassword("admin");
        user.setName("蜜柚");
        user.setAge(100);
        userRepository.save(user);
    }

    @Test
    public void select() {
        User user = userRepository.findOne(4);
        System.out.println(user);
    }
}