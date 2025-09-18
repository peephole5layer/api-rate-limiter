package com.api.api_rate_limiter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
public class RateLimiterService {

    private final StringRedisTemplate redisTemplate;

    private static final int LIMIT=100;
    private static final int WINDOW_SIZE=1;


    public RateLimiterService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean isAllowed(String userId){
        long currentMinute= Instant.now().getEpochSecond()/60;

       //key pattern= userid+":" + currentminute
        String key=userId + ":" +currentMinute;

        //increment count for each user request in redis
        Long count= redisTemplate.opsForValue().increment(key);

        if(count==1){
            redisTemplate.expire(key,WINDOW_SIZE, TimeUnit.MINUTES);
        }
        return count<=LIMIT;
    }
}
