package com.study.board.api.dto.request;

public record BookSearchRequest(
        String title,
        String author,
        Integer minPrice,
        Integer maxPrice
) {

}

