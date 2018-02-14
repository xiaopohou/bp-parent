package com.lhyzp.web.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Created by Administrator on 2018-2-5.
 */
public class Test12306 {


    public static void main(String[] args) throws IOException, URISyntaxException {
        //CloseableHttpClient httpclient = HttpClients.createDefault(); //创建httpclient
        //HttpGet httpGet = new HttpGet("https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date=2018-02-28&leftTicketDTO.from_station=WXH&leftTicketDTO.to_station=CDW&purpose_codes=ADULT"); //创建get 请求
        //CloseableHttpResponse response = httpclient.execute(httpGet); //通过httpcleint 发送get 请求
        //if(response != null)
        //{
        //    HttpEntity httpentity = response.getEntity(); //获取响应
        //    //InputStream content = httpentity.getContent();
        //    //System.out.println(content);
        //    System.out.println(EntityUtils.toString(httpentity,"UTF-8")); //采用工具来将实体进行转换输出
        //}
        //response.close();
        //httpclient.close();


        //httpClient工厂
        final SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        ClientHttpRequest request = null;
        URI uri = new URI("https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date=2018-02-10&leftTicketDTO.from_station=CDW&leftTicketDTO.to_station=RXW&purpose_codes=ADULT");
        request = httpRequestFactory.createRequest(uri, HttpMethod.GET);
        InputStream body = request.execute().getBody();
        BufferedReader br = new BufferedReader(new InputStreamReader(body));
        String line = "";
        String result = "";
        while ((line = br.readLine()) != null) {
            result += line;//获得页面内容或返回内容
        }

        JSONObject parse = (JSONObject) JSON.parse(result);

        //System.out.println(parse);

        JSONObject data = (JSONObject) parse.get("data");

        JSONArray result1 = (JSONArray) data.get("result");


        result1.forEach(s->{
            String s1 = s.toString();
            String[] s2 = s1.split("\\|");
            System.out.println("车次："+s2[3]+" 备注："+s2[1]+" 出发~到达时间："+s2[8]+"-"+s2[9]+" 历时："+s2[10]+" 商务特等座："+s2[32]+" 一等座："+s2[30]+" 二等座："+s2[31]+" 软卧："+s2[23]+" 硬座："+s2[29]);
        });

        String s = result1.get(1).toString();

        String[] s2 = s.split("\\|");
        //
        //System.out.println("车次："+s2[3]);
        //System.out.println("备注："+s2[1]);
        //System.out.println("商务特等座："+s2[32]);
        //System.out.println("一等座："+s2[30]);
        //System.out.println("二等座："+s2[31]);
        //System.out.println("软卧："+s2[23]);
        //System.out.println("硬座："+s2[29]);

        System.out.println(Arrays.toString(s2));

        br.close();
    }



}
