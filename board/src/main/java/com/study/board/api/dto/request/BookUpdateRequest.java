package com.study.board.api.dto.request;

import com.study.board.service.book.dto.BookServiceUpdateRequest;
import jakarta.validation.constraints.NotNull;

public record BookUpdateRequest(
        @NotNull(message = "Price is mandatory")
        Integer price,

        @NotNull(message = "StockQuantity is mandatory")
        Integer stockQuantity
) {
    public BookServiceUpdateRequest toService() {
        return new BookServiceUpdateRequest(
                this.price,
                this.stockQuantity
        );
    }
}
