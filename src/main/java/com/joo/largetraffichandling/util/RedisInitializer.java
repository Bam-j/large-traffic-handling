package com.joo.largetraffichandling.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisInitializer implements CommandLineRunner {

    private final ReactiveStringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) {
        redisTemplate.opsForValue()
            .set("stock:product:1", "100")  //재고 100/1000/10000 셋 중 하나
            .subscribe();
    }
}

