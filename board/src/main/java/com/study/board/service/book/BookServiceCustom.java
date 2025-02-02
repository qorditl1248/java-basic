package com.study.board.service.book;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.api.dto.response.BookResponse;
import com.study.board.domains.book.model.Book;
import com.study.board.global.exception.DuplicateIsbnException;
import com.study.board.infrastructure.book.entity.BookJpaEntity;
import com.study.board.infrastructure.book.entity.CategoryJpaEntity;
import com.study.board.infrastructure.book.repository.BookJpaRepository;
import com.study.board.infrastructure.book.repository.CategoryJpaRepository;
import com.study.board.service.book.dto.BookSearchCriteria;
import com.study.board.service.book.dto.BookServiceRequest;
import com.study.board.service.book.dto.BookServiceUpdateRequest;
import com.study.board.service.book.dto.BookServiceWithCategoryRequest;
import com.sun.jdi.request.DuplicateRequestException;
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
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    @Transactional
    public Book saveBook(BookServiceRequest request) {
        validateIsbnUnique(request.isbn());
        // 클라이언트로 받은 데이터를 Book 도메인 객체로 생성
        Book book = Book.create(
                request.title(),
                request.author(),
                request.isbn(),
                request.price(),
                request.stockQuantity(),
                null
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

        if(request.price() != null) {
            book.updatePrice(request.price());
        }

        if(request.stockQuantity() != null) {
            book.updateStock(request.stockQuantity());
        }

        entity.update(book);

        return Book.from(entity);
    }

    // 저자로 책 찾아오기
    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookJpaRepository.findByAuthor(author)
                .stream()
                .map(Book::from)
                .toList();
    }

    @Override
    public Book createBookWithCategory(BookServiceWithCategoryRequest serviceRequest, Long categoryId) {
        validateIsbnUnique(serviceRequest.isbn());
        CategoryJpaEntity categoryEntity = categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        BookJpaEntity entity = BookJpaEntity.builder()
                .title(serviceRequest.title())
                .author(serviceRequest.author())
                .isbn(serviceRequest.isbn())
                .price(serviceRequest.price())
                .stockQuantity(serviceRequest.stockQuantity())
                .category(categoryEntity)
                .build();

        BookJpaEntity savedEntity = bookJpaRepository.save(entity);
        return Book.from(savedEntity);
    }


    // 레포에서 가져올때 id가 있는지 확인을 하는 거
    private BookJpaEntity findActiveBookEntityById(Long id) {
        return bookJpaRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not fount with id: " + id)); // null 처리
    }

    // isbn이 있는지 확인
    private void validateIsbnUnique(String isbn) {
        if (bookJpaRepository.existsByIsbnAndIsDeletedFalse(isbn)) {
            throw new DuplicateIsbnException("ISBN already exists: " + isbn);
        }
    }


}
