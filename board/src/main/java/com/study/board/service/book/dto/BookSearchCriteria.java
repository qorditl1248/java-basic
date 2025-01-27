package com.study.board.service.book.dto;

import lombok.Builder;

public record BookSearchCriteria (
        String title,
        String author,
        Integer minPrice,
        Integer maxPrice
){
}
