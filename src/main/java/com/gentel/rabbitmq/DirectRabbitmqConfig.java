package com.gentel.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gentel
 * @description rabbitmq直连模式
 * @create 2019-11-28 19:06
 */

@Configuration
public class DirectRabbitmqConfig {
    /**
     * 队列
     */
    @Bean
    public Queue TestDirectQueue(){
        // true 是否持久
        return new Queue("TestDirectQueue", true);
    }

    /**
     * Direct 交换机
     */
    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    /**
     * 绑定 将队列和交换机绑定，并设置用于匹配键：TestDirectRouting
     */
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }
}