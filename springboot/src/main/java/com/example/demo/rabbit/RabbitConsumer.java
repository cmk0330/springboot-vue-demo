package com.example.demo.rabbit;

import com.example.demo.common.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = {RabbitMQConfig.RABBITMQ_DEMO_TOPIC})
public class RabbitConsumer {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("消费者从rabbitmq服务端消费消息：" + map.toString());
    }
}
