package com.example.demo.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    final static String message="topic.message";
    final static String messages="topic.messages";

    @Bean
    public Queue Queue1() {
        return new Queue("lyhTest1");
    }
    @Bean
    public Queue Queue2() {
        return new Queue("lyhTest2");
    }
    @Bean
    public Queue queueMessage(){
        return  new Queue(RabbitMqConfig.message);
    }
    @Bean
    public Queue queueMessages(){
        return  new Queue(RabbitMqConfig.messages);
    }
    @Bean
    TopicExchange exchange(){
        return  new TopicExchange("exchange");
    }
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
