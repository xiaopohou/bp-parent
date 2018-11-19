package com.lhyzp.web.common;

import com.google.zxing.*;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hashids.Hashids;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017-9-7.
 *
 * redis 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {

    @Test
    public void test1() throws WriterException, IOException, NotFoundException {
        //String filePath = "D://";
        //String fileName = "zxing.png";
        //JSONObject json = new JSONObject();
        //json.put(
        //        "zxing",
        //        "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
        //json.put("author", "shihy");
        //String content = json.toJSONString();// 内容
        //int width = 200; // 图像宽度
        //int height = 200; // 图像高度
        //String format = "png";// 图像类型
        //QRCodeUtil.encodeQRCode(filePath+fileName,content,width,height);

        //String s = QRCodeUtil.decodeQRCode("D:\\zxing.png");
        //System.out.println(s);



    }


    @Test
    public void test6() throws WriterException, IOException, NotFoundException {
        //id加密成唯一字符串
        Hashids hashids=new Hashids("this is my salt");
        String encodeId = hashids.encode(10000,10001);
        System.out.println(encodeId);

        //解密
        long[] decodeIds = hashids.decode(encodeId);
        System.out.println(Arrays.toString(decodeIds));


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
    public void test5() throws IOException {
//        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,"jobNumber"));

//        Thumbnails.of(new File("E:\\1.jpg"))
//                .size(160, 160)
//                .toFile(new File("E:\\thumbnail.jpg"));
        Thumbnails.of("E:\\14.jpg")
                .size(160, 160)
                .toFile("E:\\thumbnail.jpg");

        Thumbnails.of(new File("E:\\14.jpg"))
                .size(160, 160)
                .rotate(90)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("E:\\thumbnail.jpg")), 0.5f)
                .outputQuality(0.8)
                .toFile(new File("E:\\image-with-watermark.jpg"));


    }


    @Test
    public void test4(){
        HelloAnnotation obj=new HelloAnnotation();
        obj.resolve(HelloAnnotation.class);
    }

    @Test
    public void test3() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault(); //创建httpclient
        HttpGet httpGet = new HttpGet("http://www.baidu.com"); //创建get 请求
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
