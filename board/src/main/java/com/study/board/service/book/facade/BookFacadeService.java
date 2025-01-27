package com.study.board.service.book.facade;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.api.dto.response.BookResponse;
import com.study.board.domains.book.model.Book;
import com.study.board.service.book.BookService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 작업은 이런식으로 위에 달아줌
public class BookFacadeService {
    private final BookService bookService;

    // bookService.createBook() 호출 중 예외가 발생하면 전체 작업이 롤백
    @Transactional
    public BookResponse saveBook(BookRequest request) {

        // 클라이언트 요청 데이터(BookRequest)를 서비스 계층에서 사용할 요청 객체(BookServiceRequest)로 변환
//        Book book = bookService.saveBook(request.toServiceRequest());

        Book book = bookService.saveBook(request);

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

    // 여러개로 조회
    public List<BookResponse> searchBooks(BookSearchRequest request) {
        List<Book> books = bookService.searchBooks(request);
        return BookResponse.fromBookList(books);
    }



}
