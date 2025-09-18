package com.api.api_rate_limiter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

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

        String key=userId + ":" +currentMinute;


    }
}
