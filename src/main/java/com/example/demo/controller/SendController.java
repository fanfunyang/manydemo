package com.example.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @RequestMapping(value = "/send")
    public String send(){
        Date date =new Date();
        String content ="DATE:" + date.toString();
        amqpTemplate.convertAndSend("lyhTest1",content);
        return content;
    }
    @RequestMapping(value = "/multisend")
    public String multisend(){
        StringBuffer times=new StringBuffer();
        for (int i = 0; i < 10; i++) {
            long time =System.nanoTime();
            amqpTemplate.convertAndSend("lyhTest1","第"+i+"次发送的时间："+time);
            amqpTemplate.convertAndSend("lyhTest2","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }
    @RequestMapping("/topicSend1")
    public String  topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
        return context;
    }
    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return  context;
    }
    @RequestMapping("/fanoutSend")
    public String fanoutSend2() {
        String context = "my fanout send";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange", "", context);
        return  context;
    }
}
