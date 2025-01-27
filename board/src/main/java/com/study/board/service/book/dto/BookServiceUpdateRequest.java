package com.study.board.service.book.dto;

public record BookServiceUpdateRequest(
        Integer price,
        Integer stockQuantity
) {
}
