//package com.lhyzp.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
///**
// * Created by Administrator on 2017-9-7.
// *
// * redis 缓存配置;
// */
//@Configuration
////@EnableCaching//启用缓存，这个注解很重要；
//public class RedisCacheConfig extends CachingConfigurerSupport {
//
//
//    /**
//     * 缓存管理器.
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        cacheManager.setDefaultExpiration(10);//秒
//        return cacheManager;
//    }
//
//
//    /**
//     * redis模板操作类,类似于jdbcTemplate的一个类;
//     *
//     * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
//     *
//     * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
//     *
//     * 自己的缓存类，比如：RedisStorage类;
//     *
//     * @param factory : 通过Spring进行注入，参数在application.properties进行配置；
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(factory);
//
//        //Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        //ObjectMapper om = new ObjectMapper();
//        //om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        //jackson2JsonRedisSerializer.setObjectMapper(om);
//        //redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        //redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//    }
//
//}
