package com.study.board.api.dto.request;

import com.study.board.service.book.dto.BookSearchCriteria;

public record BookSearchRequest(
        String title,
        String author,
        Integer minPrice,
        Integer maxPrice
) {
    public BookSearchCriteria toCriteria() {
        return new BookSearchCriteria(
                this.title,
                this.author,
                this.minPrice,
                this.maxPrice
        );
    }
}

