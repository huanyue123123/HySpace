package com.gm.wj.utils;

import com.gm.wj.config.RabbitConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class RabbitConnectUtil {

    @Autowired
    private RabbitConfig rabbitConfig;

    public  Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost(rabbitConfig.getHost());
        // AMQP 端口
        factory.setPort(rabbitConfig.getPort());
        //vhost
        factory.setVirtualHost(rabbitConfig.getVirtualHost());
        //用户名
        factory.setUsername(rabbitConfig.getUsername());
        //密码
        factory.setPassword(rabbitConfig.getPassword());

        return factory.newConnection();
    }
}
