package com.api.api_rate_limiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/data")
    public String getData(){
        return " Request successful you are within rate limit";
    }
}
