package com.lhyzp;

import com.google.common.collect.Maps;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
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

    @Test
    public void test4(){
        HelloAnnotation obj=new HelloAnnotation();
        obj.resolve(HelloAnnotation.class);
    }

    @Test
    public void test3() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault(); //创建httpclient
        HttpGet httpGet = new HttpGet("http://www.lhyzp.com"); //创建get 请求
        CloseableHttpResponse response = httpclient.execute(httpGet); //通过httpcleint 发送get 请求
        if(response != null)
        {
            HttpEntity httpentity = response.getEntity();//获取响应
            System.out.println(EntityUtils.toString(httpentity,"UTF-8")); //采用工具来将实体进行转换输出
        }
        response.close();
        httpclient.close();
    }
}
