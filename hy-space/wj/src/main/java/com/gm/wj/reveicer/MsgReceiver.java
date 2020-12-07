package com.gm.wj.reveicer;

import com.alibaba.fastjson.JSON;
import com.gm.wj.config.RabbitConfig;
import com.gm.wj.entity.User;
import com.gm.wj.utils.RabbitConnectUtil;
import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ConnectionUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component

public class MsgReceiver  {


    //@RabbitListener(queues = RabbitConfig.queueName)
    public void receive(String content,Channel channel, Message message) throws IOException {
        System.out.println("消息接收"+content);
        User user = JSON.parseObject(content,User.class);
        channel.confirmSelect();
        if(user.getUsername().contains("7")){
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }

    }


}
