package com.gentel.rabbitmq.demo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Gentel
 * @description topic模式
 * @create 2019-12-03 9:54
 */

@Slf4j
public class send {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.111.83");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setVirtualHost("my_vhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routingKey = "com.gentel.rabbit";
        String message = "hello topic";

        channel.basicPublish(EXCHANGE_NAME,routingKey,null,message.getBytes());
        log.info("[x] Sent '" + routingKey + "':'" + message + "'");
        channel.close();
        connection.close();

    }
}