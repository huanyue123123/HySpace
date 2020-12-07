package com.gm.wj.producer;

import com.alibaba.fastjson.JSON;
import com.gm.wj.config.RabbitConfig;
import com.gm.wj.entity.User;
import com.gm.wj.utils.RabbitConnectUtil;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitConfig rabbitConfig;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public void sendMsg() throws IOException, TimeoutException {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setUsername("zs123123");
        u.setPassword("123123");
        users.add(u);
        u = new User();
        u.setUsername("ls444444");
        u.setPassword("14443");
        users.add(u);
        u = new User();
        u.setUsername("zs55");
        u.setPassword("123123");
        users.add(u);
        u = new User();
        u.setUsername("ls46644");
        u.setPassword("14443");
        users.add(u);
        u = new User();
        u.setUsername("zs177");
        u.setPassword("123123");
        users.add(u);
        u = new User();
        u.setUsername("ls44488844");
        u.setPassword("14443");
        users.add(u);

        users.forEach(user -> {
            String userJson = JSON.toJSONString(user);
            rabbitTemplate.convertAndSend(RabbitConfig.exchangeA,RabbitConfig.routeKeyA,userJson);
        });
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause);
        }
    }
}
