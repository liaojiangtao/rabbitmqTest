package com.gentel.rabbitmq.controller;

import com.gentel.rabbitmq.service.DirectRabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gentel
 * @description 直连模式测试
 * @create 2019-11-28 19:17
 */

@RestController
@RequestMapping(value = "/rabbit")
public class DirectRabbitMqController {

    @Autowired
    private DirectRabbitMqService directRabbitMqService;

    @GetMapping(value = "/direct")
    @ResponseBody
    public String direct(@RequestParam(value = "message") String message){
        directRabbitMqService.handlePush(message);
        return "ok";

    }
}