package com.lhyzp.biz.im.service;

import com.lhyzp.biz.im.model.Greeting;

import java.util.List;

/**
 * websocket service
 * Created by Administrator on 2017-11-14.
 */
public interface WebSocketService {

    /**
     * 广播  --  发送消息给在线用户
     * @param msg
     */
    void sendMsg(Greeting msg);

    /**
     * 发送给指定用户
     * @param users
     * @param msg
     */
    void send2Users(List<String> users, Greeting msg);
}
