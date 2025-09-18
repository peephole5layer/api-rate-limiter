package com.api.api_rate_limiter.config;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;


import java.io.IOException;

@Configuration
public class RedisConfig {

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis() throws IOException{
        redisServer =new RedisServer(6379);
        redisServer.start();
        System.out.println(" embeded redis started at port 6379");

    }

    @PreDestroy
    public void stopRedis(){
        if(redisServer!=null){
            redisServer.stop();
            System.out.println(" redis server stopped");
        }
    }
}
