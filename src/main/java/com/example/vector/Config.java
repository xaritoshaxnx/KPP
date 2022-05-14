package com.example.vector;

import com.example.vector.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("cache")
    Cache cache(){
        return new Cache();
    }

}