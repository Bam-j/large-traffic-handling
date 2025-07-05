package com.joo.largetraffichandling.controller.redistest;

import com.joo.largetraffichandling.service.redistest.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @GetMapping("/redis/set")
    public String setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return "Saved";
    }

    @GetMapping("/redis/get")
    public String getValue(@RequestParam String key) {
        return redisService.getValue(key);
    }
}

