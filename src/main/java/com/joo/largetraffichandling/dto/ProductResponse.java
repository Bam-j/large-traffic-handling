package com.joo.largetraffichandling.dto;

public record ProductResponse(
    String name,
    Long price,
    String description,
    Long stock
) { }
