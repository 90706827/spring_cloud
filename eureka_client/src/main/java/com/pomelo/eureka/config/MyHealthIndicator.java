package com.pomelo.eureka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyHealthIndicator
 * @Description 自定义某种情况下导致此服务不可用，例如数据库连接出了问题，或者连接其他系统连接不上导致服务不可以时，向eureka server上发送心跳
 * @Author Mr.Jangni
 * @Date 2018/12/7 22:25
 * @Version 1.0
 **/
public class MyHealthIndicator implements HealthIndicator {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Health health() {
        SimpleDateFormat format = new SimpleDateFormat("mm");
        String seconds = format.format(new Date());
        //模拟失败情景分钟各位大于5 发送心跳DOWN 其他情况发送UP
        boolean isHealth = false;
        if (Integer.parseInt(seconds.substring(1,2))>5) {
            isHealth = true;
        }
        logger.warn("is health :" + isHealth);
        if (isHealth) {
            return new Health.Builder(Status.DOWN).build();
        }
        return new Health.Builder(Status.UP).build();
    }

}