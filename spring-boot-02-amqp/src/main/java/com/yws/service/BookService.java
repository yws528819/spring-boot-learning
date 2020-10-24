package com.yws.service;

import com.yws.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = {"yws.news"})
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = {"yws"})
    public void receive(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
