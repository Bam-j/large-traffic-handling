package com.joo.largetraffichandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/item")
public class PageController {

    @GetMapping("/detail")
    public String getItemDetail() {
        return "itemDetail";
    }
}
