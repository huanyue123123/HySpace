package com.huanyue.spacepageclient.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/lydms/article/details/105224210
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 删除单个key
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除
     * @param keys
     */
    public void deleteKeys(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 设置超时
     * @param key
     * @param time
     */
    public void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取超时时间
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 是否有key
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 添加String
     * @param key
     * @param value
     * @param time
     */
    public void addString(String key, String value, Long time) {
        //1、通过redisTemplate设置值
        if (time == null) {
            redisTemplate.boundValueOps(key).set(value);
        } else {
            redisTemplate.boundValueOps(key).set(value, time, TimeUnit.MILLISECONDS);
        }
        /**
         *   //2、通过BoundValueOperations设置值
         *         BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey");
         *         stringKey.set("StringVaule");
         *         stringKey.set("StringValue",1, TimeUnit.MINUTES);
         *
         *         //3、通过ValueOperations设置值
         *         ValueOperations ops = redisTemplate.opsForValue();
         *         ops.set("StringKey", "StringVaule");
         *         ops.set("StringValue","StringVaule",1, TimeUnit.MINUTES);
         */

    }

    /**
     * 给String 设置过期时间
     * @param key
     * @param time
     */
    //设置过期时间(单独设置)
    public void expireString(String key, long time) {
        redisTemplate.boundValueOps(key).expire(time, TimeUnit.MILLISECONDS);
        //也可以
        // redisTemplate.expire(key,time,TimeUnit.MINUTES);
    }

    /**
     * 获取值
     * @param key
     * @return
     */
    public String getString(String key) {
        //1、通过redisTemplate设置值
        String str1 = (String) redisTemplate.boundValueOps(key).get();

        //2、通过BoundValueOperations获取值
        BoundValueOperations stringKey = redisTemplate.boundValueOps(key);
        String str2 = (String) stringKey.get();

        //3、通过ValueOperations获取值
        ValueOperations ops = redisTemplate.opsForValue();
        String str3 = (String) ops.get(key);
        return str1;
    }

    /**
     * 递增或递减
     * @param key
     * @param incr
     */
    public void increAddOrReduce(String key,Long incr){
        redisTemplate.boundValueOps(key).increment(incr);
    }

}
