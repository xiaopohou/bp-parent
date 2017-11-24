package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017-11-24.
 */
public class JedisDemo {

    @Test
    public void test1(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
    }
}
