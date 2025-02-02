package com.study.board.service.book.dto;

public record BookServiceWithCategoryRequest(
        String title,
        String author,
        String isbn,
        Integer price,
        Integer stockQuantity,
        Long categoryId
) {
}
