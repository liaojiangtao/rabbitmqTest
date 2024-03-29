package com.gentel.rabbitmq.demo.publishSubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Gentel
 * @description
 * @create 2019-12-02 19:44
 */

@Slf4j
public class send {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.111.83");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setVirtualHost("my_vhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String message = "hello publish and subscribe.";

        channel.basicPublish(EXCHANGE_NAME, "key_gentel", null, message.getBytes());
        log.info(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
        System.exit(0);
    }
}