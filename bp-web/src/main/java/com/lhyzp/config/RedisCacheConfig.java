package com.lhyzp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017-9-7.
 *
 * redis 缓存配置;
 */
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {


    /**
     * 缓存管理器.
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        cacheManager.setDefaultExpiration(300);//秒

        return cacheManager;
    }


    /**
     * redis模板操作类,类似于jdbcTemplate的一个类;
     *
     * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
     *
     * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
     *
     * 自己的缓存类，比如：RedisStorage类;
     *
     * @param factory : 通过Spring进行注入，参数在application.properties进行配置；
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(stringRedisSerializer);

        return redisTemplate;
    }

    /**
     * 自定义key.
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     * 普通使用普通类的方式的话，那么在使用@Cacheable的时候还需要指定KeyGenerator的名称
     */
//    @Override
//    public KeyGenerator keyGenerator() {
//        System.out.println("RedisCacheConfig.keyGenerator()");
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                // This will generate a unique key of the class name, the method name
//                //and all method parameters appended.
//                StringBuilder sb = new StringBuilder();
//                sb.append(o.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                System.out.println("keyGenerator=" + sb.toString());
//                return sb.toString();
//            }
//        };
//    }

}
