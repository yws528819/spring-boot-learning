package com.yws.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    private TicketService ticketService;


    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了:" + ticket );
    }

}
