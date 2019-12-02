package com.gentel.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Gentel
 * @description 直连模式测试服务类
 * @create 2019-11-28 19:25
 */

@Slf4j
@Service
public class DirectRabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param message
     */
    public void handlePush(String message) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("messageId", messageId);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
    }
}