package com.joo.largetraffichandling.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ItemPurchaseService {

    private final ReactiveStringRedisTemplate redisTemplate;
    private static final String STOCK_KEY = "stock:product:1";

    public Mono<Boolean> tryPurchase() {
        return redisTemplate.opsForValue().get(STOCK_KEY)
            .flatMap(currentStock -> {
                long stock = Long.parseLong(currentStock);
                if (stock > 0) {
                    return redisTemplate.opsForValue()
                        .decrement(STOCK_KEY)
                        .map(result -> result >= 0);
                } else {
                    return Mono.just(false);
                }
            });
    }
}
