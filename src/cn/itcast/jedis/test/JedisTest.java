package cn.itcast.jedis.test;

/*
* jedis测试类
* */

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisTest {
    /*
    * 快速入门
    * */
    @Test
    public void test1(){
        /*1. 获取连接*/
        Jedis jedis = new Jedis("localhost",6379);
        // 2. 操作
        jedis.set("username","zhangsan");
        // 3. 关闭连接
        jedis.close();
    }
    // string数据结构
    @Test
    public void test2(){
        /*1. 获取连接*/
        Jedis jedis = new Jedis();
        // 2. 操作
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex方法存储可以指定过期时间的key value
        jedis.setex("activecode",20,"hehe");
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test4(){
        /*1. 获取连接*/
        Jedis jedis = new Jedis();
        // 2. 操作
        // list存储
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        //list范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        jedis.close();
    }
}
