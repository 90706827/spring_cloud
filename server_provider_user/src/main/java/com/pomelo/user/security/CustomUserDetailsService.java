package com.pomelo.user.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomUserDetailsService
 * @Description
 * @Author Mr.Jangni
 * @Date 2018/12/8 18:28
 * @Version 1.0
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * 模拟两个账户：
     * ① 账号是user，密码是password1，角色是user-role
     * ② 账号是admin，密码是password2，角色是admin-role
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}