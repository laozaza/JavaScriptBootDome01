package com.example.javascriptbootdome01.RabbitMQ;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // 配置消息转换器，这里使用Jackson2JsonMessageConverter将消息转换为JSON格式
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    // 1. 定义一个fanout类型的交换器
    @Bean
    public Exchange fanout_exchange(){
        // 创建并返回一个fanout交换器，名称为"fanout_exchange"
        return ExchangeBuilder.fanoutExchange("fanout_exchange").build();
    }



    // 2. 定义两个默认持久化队列，分别用于处理email和sms消息
    @Bean
    public Queue fanout_queue_email(){
        // 创建并返回一个名为"fanout_queue_email"的队列，该队列用于处理email消息
        return new Queue("fanout_queue_email");
    }

    @Bean
    public Queue fanout_queue_qq(){
        // 创建并返回一个名为"fanout_queue_qq"的队列，该队列用于处理sms消息
        return new Queue("fanout_queue_qq");
    }


    @Bean
    public Queue fanout_queue_wechat(){
        // 创建并返回一个名为"fanout_queue_sms"的队列，该队列用于处理sms消息
        return new Queue("fanout_queue_wechat");
    }


    // 3. 将队列分别与交换器进行绑定
    @Bean
    public Binding bindingEmail(){
        // 创建并返回一个将"fanout_queue_email"与"fanout_exchange"绑定的操作
        // 由于是fanout交换器，不使用路由键，因此使用空字符串 ""
        return BindingBuilder.bind(fanout_queue_email()).to(fanout_exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingQQ(){
        // 创建并返回一个将"fanout_queue_qq"与"fanout_exchange"绑定的操作
        // 同样，由于是fanout交换器，不使用路由键，因此使用空字符串 ""
        return BindingBuilder.bind(fanout_queue_qq()).to(fanout_exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingWeChat(){
        // 创建并返回一个将"fanout_queue_sms"与"fanout_exchange"绑定的操作
        // 同样，由于是fanout交换器，不使用路由键，因此使用空字符串 ""
        return BindingBuilder.bind(fanout_queue_wechat()).to(fanout_exchange()).with("").noargs();
    }

}

