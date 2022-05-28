package com.example.vector;

import com.example.vector.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.vector.cache")
@ComponentScan("com.example.vector.counter")

public class Config { }

