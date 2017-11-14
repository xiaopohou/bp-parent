package com.lhyzp.biz.im.service.impl;

import com.lhyzp.biz.im.model.WiselyResponse;
import com.lhyzp.biz.im.service.WebSocketService;
import com.lhyzp.constant.WebSocketConstant;
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
    public void sendMsg(WiselyResponse msg) {
        simpMessagingTemplate.convertAndSend(WebSocketConstant.PRODUCERPATH,msg);
    }

    @Override
    public void send2Users(List<String> users, WiselyResponse msg) {
        users.forEach(userName -> {
            simpMessagingTemplate.convertAndSendToUser(userName, WebSocketConstant.P2PPUSHPATH, msg);
        });
    }
}
