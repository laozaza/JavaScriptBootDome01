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

/**
 * 用于测试RabbitMQ消息传递的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 配置RabbitMQ的交换器和队列
     */
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

    /**
     * 向 fanout 类型的交换器发布消息，不指定路由键
     */
    @Test
    public void psubPublisherAll() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("fanout_exchange", "", user);
        // 给所有队列发消息
    }

    /**
     * 向 fanout 类型的交换器发布消息，指定路由键为 "info.qq"
     */
    @Test
    public void topicPublisherQQ() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("topic_exchange", "info.qq", user);
        // 单独给qq队列发消息
    }

    /**
     * 向 fanout 类型的交换器发布消息，指定路由键为 "info.email"
     */
    @Test
    public void topicPublisherEmail() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("topic_exchange", "info.email", user);
        // 单独给邮件队列发消息
    }

    /**
     * 向 fanout 类型的交换器发布消息，指定路由键为 "info.wechat"
     */
    @Test
    public void topicPublisherWechat() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("topic_exchange", "info.wechat", user);
        // 单独给微信队列发消息
    }

    /**
     * 向 fanout 类型的交换器发布消息，指定路由键为 "info.wechat.qq"
     */
    @Test
    public void topicPublisherQQWechat() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("topic_exchange", "info.wechat.qq", user);
        // 只给QQ、微信队列发消息
    }

    /**
     * 向路由交换器发布消息，指定路由键为 "error_routing_key"
     */
    @Test
    public void routingPublisher() {
        rabbitTemplate.convertAndSend("routing_exchange", "error_routing_key", "routing send error message");
    }
}
