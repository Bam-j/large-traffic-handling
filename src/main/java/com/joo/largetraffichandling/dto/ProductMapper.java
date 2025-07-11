package com.joo.largetraffichandling.dto;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toProductResponse(Map<String, String> map) {
        return new ProductResponse(
            map.get("name"),
            Long.parseLong(map.get("price")),
            map.get("description"),
            Long.parseLong(map.get("stock"))
        );
    }
}
