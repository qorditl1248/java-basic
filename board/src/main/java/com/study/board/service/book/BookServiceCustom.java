package com.study.board.service.book;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.domains.book.model.Book;
import com.study.board.infrastructure.book.entity.BookJpaEntity;
import com.study.board.infrastructure.book.repository.BookJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 의존성 주입을 위한 생성자 자동 생성
public class BookServiceCustom implements BookService {

    // 데이터 저장을 위한 JPA 리포지토리에 의존
    private final BookJpaRepository bookJpaRepository;

//    @Override
//    @Transactional
//    public Book saveBook(BookServiceRequest request) {

//         클라이언트로 받은 데이터를 Book 도메인 객체로 생성
//        Book book = Book.create(
//                request.title(),
//                request.author(),
//                request.isbn(),
//                request.price(),
//                request.stockQuantity()
//        );
//
//         jpa 엔티티를 데이터베이스에 저장
//        BookJpaEntity entity = bookJpaRepository.save(BookJpaEntity.from(book));
//
//         jpa 엔티티를 from()메서드를 통해서 도메인 객체로 변환해서 반환
//        return Book.from(entity);
//    }

    // 저장
    @Override
    @Transactional
    public Book saveBook(BookRequest request) {
        BookJpaEntity entity = bookJpaRepository.save(request.toEntity());
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

    // 책 검색
    @Override
    public List<Book> searchBooks(BookSearchRequest request) {
        if(request.title() == null && request.author() == null && request.minPrice() == null && request.maxPrice() == null) {
            throw new DataIntegrityViolationException("검색할 내용이 없습니다");
        }

        List<BookJpaEntity> bookList = bookJpaRepository.searchByCriteria(
                request.title(),
                request.author(),
                request.minPrice(),
                request.maxPrice()
        );

        return bookList.stream().map(Book::from).toList();
    }


    // 레포에서 가져올때 id가 있는지 확인을 하는 거
    private BookJpaEntity findActiveBookEntityById(Long id) {
        return bookJpaRepository.findActiveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not fount with id: " + id)); // null 처리
    }



}
