package com.gm.wj.reveicer;

import com.gm.wj.utils.RabbitConnectUtil;
import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ConnectionUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class MsgReceiver {

    @Autowired
    private RabbitConnectUtil rabbitConnectUtil;

    public void receive() throws IOException, TimeoutException {
        //获取连接
        Connection connection = rabbitConnectUtil.getConnection();

        //创建频道
        Channel channel = connection.createChannel();

        //定义队列的消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("接收到一个消息： " + message);
            }
        };

        channel.basicConsume("QUEUEA", true, consumer);
    }
}
