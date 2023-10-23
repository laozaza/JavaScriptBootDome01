package com.example.javascriptbootdome01;

import com.example.javascriptbootdome01.RabbitMQ.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 此方法用于配置 RabbitMQ 的交换器和队列
    @Test
    public void amqpAdmin() {
        // 1. 定义一个名为 "fanout_exchange" 的 fanout 类型的交换器
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));

        // 2. 定义三个默认持久化队列，分别用于处理 email、qq 和 wechat 消息
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_qq"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_wechat"));

        // 3. 将队列分别与交换器进行绑定
        amqpAdmin.declareBinding(new Binding("fanout_queue_email", Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_qq", Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_wechat", Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
    }

    // 此方法用于发布消息到 fanout 类型的交换器
    @Test
    public void psubPublisherAll() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        // 发布 user 对象消息到名为 "fanout_exchange" 的 fanout 交换器
        rabbitTemplate.convertAndSend("fanout_exchange", "", user);
        //给所有队列发消息
    }
    @Test
    public void topicPublisherQQ() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        // (4) 发送同时订阅邮件、qq 和微信的用户信息，路由键为 "info.email.qq.wechat"
        rabbitTemplate.convertAndSend("topic_exchange", "info.qq",user );
        //单独给qq队列消息
    }

    @Test
    public void topicPublisherEmail() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        // (4) 发送同时订阅邮件、qq 和微信的用户信息，路由键为 "info.email.qq.wechat"
        rabbitTemplate.convertAndSend("topic_exchange", "info.email",user );
        //单独给邮件队列发消息
    }

    @Test
    public void topicPublisherWechat() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        // (4) 发送同时订阅邮件、qq 和微信的用户信息，路由键为 "info.email.qq.wechat"
        rabbitTemplate.convertAndSend("topic_exchange", "info.wechat",user );
        //单独给微信队列发消息
    }

    @Test
    public void topicPublisherQQWechat() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        // (4) 发送同时订阅邮件、qq 和微信的用户信息，路由键为 "info.email.qq.wechat"
        rabbitTemplate.convertAndSend("topic_exchange", "info.wechat.qq",user );
        //只给QQ、微信队列发消息
    }


    // 此方法用于发布消息到 "routing_exchange" 的路由交换器
    @Test
    public void routingPublisher() {
        // 发布字符串消息到 "routing_exchange"，指定路由键为 "error_routing_key"
        rabbitTemplate.convertAndSend("routing_exchange", "error_routing_key", "routing send error message");
    }

    // 此方法用于发布消息到 "topic_exchange" 的主题交换器
}
