package com.huanyue.spacepageclient.controller;

import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/redis")
@Api(tags = {"redis"})
public class RedisContriller {

    @Autowired
    private RedisUtil redisUtil;


    @GetMapping("/zsetTest")
    @ApiOperation(value = "zsetTest")
    public Result getZsetTest(String key,String value,Long time) throws InterruptedException {
        redisUtil.addString(key,value,null);
        System.out.println("获取值："+redisUtil.getString(key));
        System.out.println("获取超时时间："+redisUtil.getExpire(key));
        redisUtil.expire(key,10000);
        System.out.println("获取超时时间："+redisUtil.getExpire(key));
        redisUtil.increAddOrReduce(key,5L);
        System.out.println("获取值："+redisUtil.getString(key));
        System.out.println("获取是否有key："+redisUtil.hasKey(key));
        Thread.sleep(10000);
        System.out.println("获取是否有key："+redisUtil.hasKey(key));
        return new Result(1,"success",1);
    }
}
