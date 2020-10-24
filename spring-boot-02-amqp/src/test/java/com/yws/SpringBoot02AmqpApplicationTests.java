package com.yws;

import com.yws.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;


    @Test
    public void createExchange() {
        //创建交换机
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");
        //创建队列
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqpadmin.yws", null));

    }




    /**
     * 单播（点对点）
     */
    @Test
    public void contextLoads() {

        //Message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange, routingKey, message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给RabbitMQ
        //rabbitTemplate.convertAndSend(exchange, routingKey, object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("hello", 123, true));
        //对象被序列化以后发送出去
        //rabbitTemplate.convertAndSend("yws.exchange.direct", "yws.news", map);
        rabbitTemplate.convertAndSend("yws.exchange.direct", "yws.news", new Book("西游记", "吴承恩"));

    }

    //接收数据，如何将数据自动的转为json发送出去
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("yws.news");
        System.out.println(o.getClass());
        System.out.println(o);

    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("yws.exchange.fanout", "", new Book("水浒传", "施耐庵"));
    }
}
