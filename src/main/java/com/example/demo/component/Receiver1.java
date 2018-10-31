package com.example.demo.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "lyhTest1")
public class Receiver1 {
    private final Logger log=LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void receiver1(String msg){
        System.out.println("TEST RECEIVER   1"+msg);
        log.info("LOGGER :TEST RECEIVER   1"+msg);
    }
}
