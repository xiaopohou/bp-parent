package com.lhyzp.api.goods.controller;

import com.lhyzp.commons.base.BaseController;
import com.lhyzp.goods.service.GoodsStockService;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-9-28.
 */
@RestController
@RequestMapping("api/goods/stock")
public class GoodsStockController extends BaseController{


    @Autowired
    private GoodsStockService goodsStockService;

    @GetMapping
    public String killTest(){
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //开50个线程模拟并发秒杀下单
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                // 创建httppost
                HttpPost httppost = new HttpPost("https://127.0.0.1:8080/api/goods/order");
                // 创建参数队列
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                formparams.add(new BasicNameValuePair("stockId", "1"));
                formparams.add(new BasicNameValuePair("amount", "1"));
                UrlEncodedFormEntity uefEntity;
                try {
                    uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
                    httppost.setEntity(uefEntity);
                    System.out.println("executing request " + httppost.getURI());
                    CloseableHttpResponse response = httpclient.execute(httppost);
                    try {
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            System.out.println("--------------------------------------");
                            System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                            System.out.println("--------------------------------------");
                        }
                    } finally {
                        response.close();
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 关闭连接,释放资源
                    try {
                        httpclient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        return success();
    }


}
