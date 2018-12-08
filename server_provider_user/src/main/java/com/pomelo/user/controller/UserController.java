package com.pomelo.user.controller;

import com.pomelo.user.entity.User;
import com.pomelo.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @ClassName UserContorller
 * @Description user controller
 * @Author Mr.Jangni
 * @Date 2018/12/7 23:48
 * @Version 1.0
 **/

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority c : collection) {
                // 打印当前登录用户的信息
                logger.info("当前用户是{}，角色是{}", user.getUsername(), c.getAuthority());
            }
        } else {
            logger.info("do other things");
        }
        return this.userRepository.findOne(id);
    }

}