package com.study.board.api.dto.request;

import com.study.board.domains.book.model.Book;
import com.study.board.infrastructure.book.entity.BookJpaEntity;
import com.study.board.service.book.dto.BookServiceRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// record를 통해서 불변객체로 구현
// 클라이언트로 요청받은 데이터를 캡슐화!
// 도메인이나 엔티티 생성에 필요한 데이터로 사용되는 거!
public record BookRequest(
        @NotBlank(message = "title is mandatory")
        String title,

        @NotBlank(message = "author is mandatory")
        String author,

        @NotBlank(message = "isbn is mandatory")
        String isbn,

        @NotNull(message = "Price is mandatory")
        Integer price,

        @NotNull(message = "StockQuantity is mandatory")
        Integer stockQuantity
) {

    // 서비스 계층에서 사용할 요청 객체로 변환
    // 클라이언트 데이터를 캡슐화한 DTO
//    public BookServiceRequest toServiceRequest() {
//        return new BookServiceRequest(
//                this.title,
//                this.author,
//                this.isbn,
//                this.price,
//                this.stockQuantity
//        );
//    }

    public BookJpaEntity toEntity() {
        return BookJpaEntity.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }
}
