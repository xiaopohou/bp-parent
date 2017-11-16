package com.lhyzp.biz.im.service.impl;

import com.lhyzp.biz.im.model.Greeting;
import com.lhyzp.biz.im.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-11-14.
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendMsg(Greeting msg) {
        //广播消息
        simpMessagingTemplate.convertAndSend("/topic/greetings",msg);
    }

    @Override
    public void send2Users(List<String> users, Greeting msg) {
        users.forEach(userName -> {
            //一对一发送，发送特定的客户端
            simpMessagingTemplate.convertAndSendToUser(userName, "/message", msg);
        });
    }
}
