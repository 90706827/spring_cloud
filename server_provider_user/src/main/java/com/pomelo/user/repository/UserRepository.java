package com.pomelo.user.repository;

import com.pomelo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description user
 * @Author Mr.Jangni
 * @Date 2018/12/7 23:46
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}