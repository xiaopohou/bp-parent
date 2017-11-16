package com.lhyzp.websocket;

import com.google.common.collect.Lists;
import com.lhyzp.base.BaseController;
import com.lhyzp.biz.im.model.Greeting;
import com.lhyzp.biz.im.model.WiselyMessage;
import com.lhyzp.biz.im.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * websocket
 * Created by Administrator on 2017-11-16.
 */
@Controller
public class GreetingController extends BaseController{

    @Autowired
    private WebSocketService webSocketService;


    //@MessageMapping注解确保如果将消息发送到目标/ hello，则会调用greeting()方法。
    //消息的有效内容绑定到一个HelloMessage对象，该对象被传递到greeting()。
    //在内部，该方法的实现通过使线程睡眠1秒来模拟处理延迟。这是为了说明在客户端发送消息之后，服务器可以采取与需要异步处理消息一样长的时间。客户可以继续其需要做的任何工作，而不必等待响应。
    //在延迟1秒后，greeting()方法创建一个Greeting对象并返回它。返回值将广播给所有订阅者，如@SendTo注释中指定的/topic/greetings。
    @MessageMapping("hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(WiselyMessage message) throws InterruptedException {

        return new Greeting("广播消息:"+message.getName()+"!");
    }

    @MessageMapping("message")
    @SendToUser("/message")
    public void userMessage(Greeting message, @RequestParam(value="email")String email){
        List<String> users = Lists.newArrayList();
        users.add(email);
        webSocketService.send2Users(users,message);
    }

}
