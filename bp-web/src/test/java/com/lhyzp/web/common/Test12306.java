package com.lhyzp.web.common;


import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018-2-5.
 */
public class Test12306 {

    static Logger logger = LoggerFactory.getLogger(Test12306.class);

    // 代表每秒最多2个
    // guava限流采用的是令牌桶的方式
    private static RateLimiter rateLimiter = RateLimiter.create(2);

    public static void main(String[] args) throws InterruptedException {
        for (int index = 0; index < 1000; index++) {
            // 单位时间内获取令牌
            if (rateLimiter.tryAcquire(190, TimeUnit.MILLISECONDS)) {
                handle(index);
            }else{
                logger.info("未获取到令牌");
            }
        }
    }
    private static void handle(int i) throws InterruptedException {
        logger.info("{}",i);
    }


}
