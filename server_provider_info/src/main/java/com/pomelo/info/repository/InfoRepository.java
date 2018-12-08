package com.pomelo.info.repository;

import com.pomelo.info.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName InfoRepository
 * @Description
 * @Author Mr.Jangni
 * @Date 2018/12/8 20:58
 * @Version 1.0
 **/
@Repository
public interface InfoRepository extends JpaRepository<Info,Integer> {

}