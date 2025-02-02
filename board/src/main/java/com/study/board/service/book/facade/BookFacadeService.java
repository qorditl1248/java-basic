package com.study.board.service.book.facade;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.api.dto.request.BookUpdateRequest;
import com.study.board.api.dto.request.BookWithCategoryRequest;
import com.study.board.api.dto.response.BookResponse;
import com.study.board.domains.book.model.Book;
import com.study.board.service.book.BookService;
import com.study.board.service.book.dto.BookServiceWithCategoryRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 작업은 이런식으로 위에 달아줌
public class BookFacadeService {
    private final BookService bookService;

    // bookService.createBook() 호출 중 예외가 발생하면 전체 작업이 롤백
    @Transactional
    public BookResponse saveBook(BookRequest request) {

        // 클라이언트 요청 데이터(BookRequest)를 서비스 계층에서 사용할 요청 객체(BookServiceRequest)로 변환
        Book book = bookService.saveBook(request.toServiceRequest());

        // 서비스 계층에서 반환된 도메인 객체(Book)를 클라이언트 응답 객체(BookResponse)로 변환
        return BookResponse.from(book);
    }

    // 아이디로 조회
    public BookResponse getBookById(@Positive(message = "ID Must be positive") Long id) {
        return BookResponse.from(bookService.getBookById(id));
    }

    // 수정
    @Transactional
    public BookResponse updateStock(@Positive(message = "ID Must be positive") Long id,
                                    @NotNull(message = "Quantity is required") Integer quantity) {
        return BookResponse.from(bookService.updateStock(id, quantity));
    }

    // 소프트 삭제
    @Transactional
    public void deleteBook(@Positive(message = "ID Must be positive") Long id) {
        bookService.deleteBook(id);
    }

    // 이름,저자,가격들 조회
    public List<BookResponse> searchBooks(BookSearchRequest request) {
        return bookService.searchBooks(request.toCriteria())
                .stream()
                .map(BookResponse::from)
                .toList();
    }

    // 가격, 수량 변경
    public BookResponse updateBookDetails(Long id, BookUpdateRequest request) {
       return BookResponse.from(bookService.updateById(id, request.toService()));
    }

    // 저자로 책 조회
    public List<BookResponse> getBooksByAuthor(String author) {
        return bookService.getBooksByAuthor(author).stream()
                .map(BookResponse::from)
                .toList();
    }

    public BookResponse createBookWithCategory(@Valid BookWithCategoryRequest request) {
        validateBookRequest(request);
        Book bookWithCategory =
                bookService.createBookWithCategory(toServiceRequest(request), request.categoryId());

        log.info("category name: {}", bookWithCategory.getCategory().getName());
        log.info("category code: {}", bookWithCategory.getCategory().getCode());
        return BookResponse.from(bookWithCategory);
    }


    private void validateBookRequest(BookRequest request) {
        if (request.price() < 0) {
            throw new IllegalArgumentException("가격이 0 보다 작을 수는 없습니다.");
        }

        if (request.stockQuantity() < 0) {
            throw new IllegalArgumentException("수량이 0보다 작을 수는 없습니다.");
        }

    }

    private void validateBookRequest(BookWithCategoryRequest request) {
        if (request.price() < 0) {
            throw new IllegalArgumentException("가격이 0 보다 작을 수는 없습니다.");
        }

        if (request.stockQuantity() < 0) {
            throw new IllegalArgumentException("수량이 0보다 작을 수는 없습니다.");
        }

    }

    private BookServiceWithCategoryRequest toServiceRequest(BookWithCategoryRequest request) {
        return new BookServiceWithCategoryRequest(
                request.title(),
                request.author(),
                request.isbn(),
                request.price(),
                request.stockQuantity(),
                request.categoryId()
        );
    }

}
