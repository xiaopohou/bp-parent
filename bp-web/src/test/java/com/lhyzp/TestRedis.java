package com.lhyzp;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-7.
 *
 * redis 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {

    @Test
    public void test1(){
        Map<String,Object> map= Maps.newHashMap();
        map.put("a",null);
        map.put("b","1");

        if(map.containsKey("a")){
            System.out.println("key存在");
            Object c = map.get("c");
        }

        if(map.containsKey("b")){
            System.out.println("b的key存在");
        }
    }

    @Test
    public void test2(){
        System.out.println(BigDecimal.valueOf(500));
        if(BigDecimal.valueOf(500l).compareTo(BigDecimal.valueOf(100l))==1){
            System.out.println("大于成立");
        }
    }
}
