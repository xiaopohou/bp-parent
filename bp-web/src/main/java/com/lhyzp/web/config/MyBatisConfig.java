package com.lhyzp.web.config;

import com.lhyzp.web.filter.SQLStatsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis插件配置
 * Created by Administrator on 2018-2-2.
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public SQLStatsInterceptor sqlStatsInterceptor(){
        SQLStatsInterceptor sqlStatsInterceptor = new SQLStatsInterceptor();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        sqlStatsInterceptor.setProperties(properties);
        return sqlStatsInterceptor;
    }

}
