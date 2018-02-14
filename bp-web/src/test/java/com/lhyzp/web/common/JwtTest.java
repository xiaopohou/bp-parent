package com.lhyzp.web.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-2-14.
 */
public class JwtTest {

    /**
     * 秘钥保存在服务端
     */
    public static String SECRET="PENG";

    /**
     * 生成token
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String createToken() throws UnsupportedEncodingException {
        //签发时间
        Date date=new Date();

        //过期时间
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,1);
        Date expirDate=nowTime.getTime();

        Map<String,Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token= JWT.create()
                .withHeader(map)//header
                .withClaim("name","zpeng")  //payload
                .withClaim("age","26")
                .withClaim("org","今日头条")
                .withExpiresAt(expirDate) //设置过期时间,必须大于签发时间
                .withIssuedAt(date) //设置签发时间
                .sign(Algorithm.HMAC256(SECRET)); //加密
        return token;
    }

    /**
     *解密token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier= JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt=null;
        try {
            jwt=verifier.verify(token);
        }catch (TokenExpiredException e){
            throw new RuntimeException("token已过期");
        }


        return jwt.getClaims();
    }


    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        String token = createToken();
        System.out.println("token: "+token);

        Map<String, Claim> claimMap = verifyToken(token);
        System.out.println(claimMap.get("name").asString());
        System.out.println(claimMap.get("age").asString());
        System.out.println(claimMap.get("org").asString());



        //测试过期token

        Thread.sleep(61000);
        Map<String, Claim> stringClaimMap = verifyToken(token);


    }
}
