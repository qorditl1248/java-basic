package com.study.board.service.book;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.domains.book.model.Book;
import com.study.board.infrastructure.book.entity.BookJpaEntity;
import com.study.board.infrastructure.book.repository.BookJpaRepository;
import com.study.board.service.book.dto.BookSearchCriteria;
import com.study.board.service.book.dto.BookServiceRequest;
import com.study.board.service.book.dto.BookServiceUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor // 의존성 주입을 위한 생성자 자동 생성
public class BookServiceCustom implements BookService {

    // 데이터 저장을 위한 JPA 리포지토리에 의존
    private final BookJpaRepository bookJpaRepository;

    @Override
    @Transactional
    public Book saveBook(BookServiceRequest request) {

        // 클라이언트로 받은 데이터를 Book 도메인 객체로 생성
        Book book = Book.create(
                request.title(),
                request.author(),
                request.isbn(),
                request.price(),
                request.stockQuantity()
        );

        // jpa 엔티티를 데이터베이스에 저장
        BookJpaEntity entity = bookJpaRepository.save(BookJpaEntity.from(book));

        // jpa 엔티티를 from()메서드를 통해서 도메인 객체로 변환해서 반환
        return Book.from(entity);
    }


    @Override
    public Book getBookById(Long id) {
        return Book.from(findActiveBookEntityById(id));
    }

    @Override
    @Transactional
    public Book updateStock(Long id, Integer quantity) {
        BookJpaEntity entity = findActiveBookEntityById(id);
        Book book = Book.from(entity);
        book.updateStock(quantity);
        entity.update(book);

        return Book.from(entity);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        BookJpaEntity entity = findActiveBookEntityById(id);
        entity.delete();
    }

    @Override
    public List<Book> searchBooks(BookSearchCriteria request) {
        List<BookJpaEntity> entity = bookJpaRepository.searchBookByCriteria(
                request.title(),
                request.author(),
                request.minPrice(),
                request.maxPrice()
        );
        return entity.stream().map(Book::from).toList();
    }


    // 수량, 가격만 업데이트
    @Override
    @Transactional
    public Book updateById(Long id, BookServiceUpdateRequest request) {
        BookJpaEntity entity = findActiveBookEntityById(id);
        Book book = Book.from(entity);
        book.updatePriceAndStock(request.price(), request.stockQuantity());
        entity.update(book);

        return Book.from(entity);
    }

    @Override
    public Book getBooksByAuthor(String author) {
        BookJpaEntity entity = bookJpaRepository.findByAuthor(author);
        return Book.from(entity);
    }


    // 레포에서 가져올때 id가 있는지 확인을 하는 거
    private BookJpaEntity findActiveBookEntityById(Long id) {
        return bookJpaRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not fount with id: " + id)); // null 처리
    }



}
