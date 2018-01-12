package com.lhyzp.web.api.goods.controller;

import com.lhyzp.biz.goods.service.GoodsStockService;
import com.lhyzp.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URI;

/**
 * Created by Administrator on 2017-9-28.
 */
@RestController
@RequestMapping("api/goods/stock")
public class GoodsStockController extends BaseController {


    @Autowired
    private GoodsStockService goodsStockService;

    @GetMapping
    public String killTest(Integer amount){
        //httpClient工厂
        final SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        //开50个线程模拟并发秒杀下单
        for (int i = 0; i < 150; i++) {
            //购买人姓名
            final String consumerName = "consumer" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClientHttpRequest request = null;
                    try {
                        URI uri = new URI("http://127.0.0.1:8085/api/goods/order?amount="+amount+"&stock.id=1&user.id=1");
                        request = httpRequestFactory.createRequest(uri, HttpMethod.POST);
                        InputStream body = request.execute().getBody();
                        BufferedReader br = new BufferedReader(new InputStreamReader(body));
                        String line = "";
                        String result = "";
                        while ((line = br.readLine()) != null) {
                            result += line;//获得页面内容或返回内容
                        }
                        System.out.println(consumerName+":"+result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return success();
    }


}
