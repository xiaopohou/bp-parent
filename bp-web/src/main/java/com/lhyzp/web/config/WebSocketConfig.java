package com.lhyzp.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置STOMP 消息
 * Created by Administrator on 2017-11-16.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    //WebSocketConfig用@Configuration进行注解，表示它是一个Spring配置类。它也注释为@EnableWebSocketMessageBroker。顾名思义，
    // @EnableWebSocketMessageBroker启用WebSocket消息处理，由消息代理支持。
    //configureMessageBroker()方法覆盖WebSocketMessageBrokerConfigurer中的默认方法来配置消息代理。
    // 它通过调用enableSimpleBroker()来启用一个简单的基于内存的消息代理，将问候语消息返回给客户端，前缀为“/ topic”。
    // 它还为绑定为@MessageMapping注解方法的邮件指定“/app”前缀。该前缀将用于定义所有消息映射;例如，“/app/hello”是GreetingController.greeting()方法映射到的端点。
    //registerStompEndpoints()方法注册“/ gs-guide-websocket”端点，启用SockJS后备选项，以便在WebSocket不可用时可以使用备用传输。
    // SockJS客户端将尝试连接到“/ gs-guide-websocket”并使用最好的传输（websocket，xhr-streaming，xhr-polling等）。


    //config.enableSimpleBroker("/topic","/user");这句表示在topic和user这两个域上可以向客户端发消息；
    //config.setUserDestinationPrefix("/user/");这句表示给指定用户发送（一对一）的主题前缀是“/user/”;
    //config.setApplicationDestinationPrefixes("/app");这句表示客户端向服务端发送时的主题上面需要加"/app"作为前缀；
    //registry.addEndpoint("/gs-guide-websocket").withSockJS();这个和客户端创建连接时的url有关，后面在客户端的代码中可以看到。


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic","/user");
        config.setUserDestinationPrefix("/user");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
