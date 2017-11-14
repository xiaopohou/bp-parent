package com.lhyzp.auth;

import com.google.common.collect.Lists;
import com.lhyzp.biz.im.model.WiselyMessage;
import com.lhyzp.biz.im.model.WiselyResponse;
import com.lhyzp.biz.im.service.WebSocketService;
import com.lhyzp.constant.WebSocketConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *
 * Created by Administrator on 2017-11-14.
 */
@Controller
public class WebsocketController {

    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping(WebSocketConstant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo(WebSocketConstant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WiselyResponse say(WiselyMessage message) throws Exception {
        List<String> users = Lists.newArrayList();
        users.add("d892bf12bf7d11e793b69c5c8e6f60fb");//此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        webSocketService.send2Users(users, new WiselyResponse("admin hello"));

        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }
}
