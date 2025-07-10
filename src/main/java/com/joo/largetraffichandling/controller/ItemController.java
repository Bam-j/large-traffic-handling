package com.joo.largetraffichandling.controller;

import com.joo.largetraffichandling.service.ItemPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemPurchaseService itemPurchaseService;

    @PostMapping("/purchase")
    public Mono<ResponseEntity<String>> purchaseItem() {
        return itemPurchaseService.tryPurchase()
            .map(success -> success
                ? ResponseEntity.ok("구매 요청 성공")
                : ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("상품이 품절입니다.")
            );
    }
}
