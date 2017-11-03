package com.lhyzp;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
            if(map.get("c")==null){
                System.out.println("key为c的map不存在");
            }
        }

        if(map.containsKey("b")){
            System.out.println("b的key存在");
        }
    }

    @Test
    public void test2() throws Exception {

        String str="123";
        String key="ndE2jdZNFixH9G6Aidsfyf7lYT3PxW";
        String s = sha256_HMAC(str, key);
        System.out.println(s);
    }

    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    private static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = EncryptDemo.byteArrayToHexString(bytes);
            return hash;
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    @Test
    public void test5(){
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,"jobNumber"));
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
