package com.lhyzp.web.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 启用redis缓存session （必须能连上redis 不然启动报错）
 * 做负载均衡时,session共享的解决方案
 * Created by Administrator on 2017-11-3.
 */
@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 360)//maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
public class RedisSessionConfig  {

}
