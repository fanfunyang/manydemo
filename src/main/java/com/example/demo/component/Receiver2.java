package com.example.demo.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "lyhTest2")
public class Receiver2 {
    @RabbitHandler
    public void receiver2(String msg){
        System.out.println("TEST RECEIVER   2"+msg);
    }
}
