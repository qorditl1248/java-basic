package com.study.board.api.dto.response;
import com.study.board.domains.book.model.Book;



public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        Integer price,
        Integer stockQuantity,
        String category
) {

// 서비스 계층에서 변환된 도메인 객체를 클라이언트가 이해할 수 있는 형식으로 변환
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getStockQuantity(),
                book.getCategory() != null ? book.getCategory().getName() : null
        );
    }
}