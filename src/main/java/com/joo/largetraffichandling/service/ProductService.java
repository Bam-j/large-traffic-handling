package com.joo.largetraffichandling.service;

import com.joo.largetraffichandling.dto.ProductMapper;
import com.joo.largetraffichandling.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final ProductMapper productMapper;

    public Mono<ProductResponse> getProduct(String key) {
        return redisTemplate.opsForHash().entries(key)
            .collectMap(
                entry -> entry.getKey().toString(),
                entry -> entry.getValue().toString()
            )
            .map(productMapper::toProductResponse);
    }
}
