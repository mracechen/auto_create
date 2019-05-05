package com.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import utils.SingleArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StartTran extends Thread implements ApplicationRunner {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("自启动。。。");
        this.start();
    }

    public void run(){
//        ZSetOperations.TypedTuple<TranDO> objectTypedTuple1 = new DefaultTypedTuple<>(e,e.getValue());
//        Set<ZSetOperations.TypedTuple<TranDO>> tuples = new HashSet<>();
//        tuples.add(objectTypedTuple1);
//        redisTemplate.opsForZSet().add("tran2",null);
//        try{
//            while(true){
//                List instance = SingleArray.getInstance();
//                if(instance.size()>0){
//                    synchronized (instance){
//                        redisUtils.szSet("tran2",instance);
//                        instance.clear();
//                    }
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}