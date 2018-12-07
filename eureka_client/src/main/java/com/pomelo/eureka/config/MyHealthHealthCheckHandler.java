package com.pomelo.eureka.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;

/**
 * @ClassName MyHealthHealthCheckHandler
 * @Description 自定义某种情况下导致此服务不可用，例如数据库连接出了问题，或者连接其他系统连接不上导致服务不可以时，向eureka server上发送心跳
 * @Author Mr.Jangni
 * @Date 2018/12/7 22:32
 * @Version 1.0
 **/
public class MyHealthHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if (status == Status.UP) {
            return InstanceInfo.InstanceStatus.UP;
        } else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}