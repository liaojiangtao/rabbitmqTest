package com.gentel.rabbitmq.demo.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Gentel
 * @description 路由模式
 * @create 2019-12-03 8:58
 */

@Slf4j
public class sendInfo {
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.111.83");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setVirtualHost("my_vhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String severity = "INFO";
        String message = "info message";

        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
        log.info(" [x] Sent '" + severity + "':'" + message + "'");

        channel.close();
        connection.close();
    }

}