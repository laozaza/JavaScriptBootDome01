package com.example.javascriptbootdome01.RabbitMQ;


import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    /**
     * Publish/Subscribe工作接收、处理邮件业务
     */
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("fanout_queue_email"), exchange =
    @Exchange(value = "fanout_exchange", type = "fanout")))
    public void psubConsumerEmailAno(User user) {
        // 当fanout交换器发布消息到fanout_queue_email队列时，这个方法将被触发
        // 用于处理邮件业务消息，参数 user 包含消息内容
        System.out.println("邮件业务接收到消息： " + user);
    }

//@RabbitListener(queues = "fanout_queue_email")
//public void psubConsumerEmail(Message message) {
//    byte[] body = message.getBody();
//    String s = new String(body);
//    System.out.println("邮件业务接收到消息： "+s);
//}

    /**
     * Publish/Subscribe工作接收、处理短信业务
     */

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("fanout_queue_qq"), exchange =
    @Exchange(value = "fanout_exchange", type = "fanout")))
    public void psubConsumerQQAno(User user) {
        // 当fanout交换器发布消息到fanout_queue_qq队列时，这个方法将被触发
        // 用于处理短信业务消息，参数 user 包含消息内容
        System.out.println("QQ业务接收到消息： " + user);
    }

    /**
     * Publish/Subscribe工作接收、处理短信业务
     */
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("fanout_queue_wechat"), exchange =
    @Exchange(value = "fanout_exchange", type = "fanout")))
    public void psubConsumerWechatAno(User user) {
        // 当fanout交换器发布消息到fanout_queue_wechat队列时，这个方法将被触发
        // 用于处理短信业务消息，参数 user 包含消息内容
        System.out.println("微信业务接收到消息： " + user);
    }


//@RabbitListener(queues = "fanout_queue_sms")
//public void psubConsumerSms(Message message) {
//    byte[] body = message.getBody();
//    String s = new String(body);
//    System.out.println("短信业务接收到消息： "+s);
//}

    /**
     * 路由模式消息接收、处理error级别日志信息
     */

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("routing_queue_error"), exchange =
    @Exchange(value = "routing_exchange", type = "direct"),
            key = "error_routing_key"))
    public void routingConsumerError(String message) {
        // 当error_routing_key路由键的消息发布到routing_queue_error队列时，这个方法将被触发
        // 用于处理error级别日志消息
        System.out.println("接收到error级别日志消息： " + message);
    }

    /**
     * 路由模式消息接收、处理info、error、warning级别日志信息
     */

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("routing_queue_all"), exchange =
    @Exchange(value = "routing_exchange", type = "direct"),
            key = {"error_routing_key", "info_routing_key", "warning_routing_key"}))
    public void routingConsumerAll(String message) {
        // 当error_routing_key、info_routing_key或warning_routing_key的消息发布到routing_queue_all队列时，这个方法将被触发
        // 用于处理info、error、warning等级别日志消息
        System.out.println("接收到info、error、warning等级别日志消息： " + message);
    }

    /**
     * 通配符模式消息接收、进行邮件业务订阅处理
     */

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_email"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.email.#"))
    public void topicConsumerEmail(User user) {
        // 当满足通配符规则的消息发布到topic_queue_email队列时，这个方法将被触发
        // 用于处理邮件订阅需求处理消息
        System.out.println("接收到邮件订阅需求处理消息： " + user);
    }

    /**
     * 通配符模式消息接收、进行短信业务订阅处理
     */

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_qq"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.qq.#"))
    public void topicConsumerQQ(User user) {
        // 当满足通配符规则的消息发布到topic_queue_sms队列时，这个方法将被触发
        // 用于处理短信订阅需求处理消息
        System.out.println("接收到QQ订阅需求处理消息： " + user);
    }

    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_wechat"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.wechat.#"))
    public void topicConsumerWechat(User user) {
        // 当满足通配符规则的消息发布到topic_queue_wechat队列时，这个方法将被触发
        // 用于处理短信订阅需求处理消息
        System.out.println("接收到微信订阅需求处理消息： " + user);
    }

}
