package com.study.board.domains.book.model;

import com.study.board.infrastructure.book.entity.BookJpaEntity;
import lombok.Builder;
import lombok.Getter;

/**
 * 도메인 객체, 엔티티 객체
 *
 * 도메인 객체 -> 순수 자바 객체
 * 엔티티 객체 -> 데이터 베이스와 같다라고 보면 됨, 하나의 테이블과 데이터상 같다
 *
 * 여기는 도메인 객체!! 데이터 베이스와 직접 연결 x
 *
 * 	도메인(예시. book): 책의 할인, 재고 관리 같은 비즈니스 로직.
 * 	엔티티(예시. BookJpaEntity): 데이터베이스에 책 정보를 저장하거나 가져오는 역할.
 *
 * 책이라는게 변하면 여기가 변해야함
 */

@Builder
@Getter
public class Book {
    private final Long id;
    private String title;
    private String author;
    private String isbn;
    private int price;
    private int stockQuantity;
    private boolean isDeleted;

    // 정적팩토리메소드로 만들기 위해서 생성자 접근 못하게 private
    private Book(Long id, String title,
                 String author, String isbn,
                 int price, int stockQuantity,
                 boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.isDeleted = isDeleted;
    }

    // 정적팩토리 메서드 하나 생성
    public static Book create(String title, String author, String isbn, int price, int stockQuantity) {
        return Book.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }

    // JPA 엔티티를 도메인 객체로 변환
    public static Book from(BookJpaEntity entity) {
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .price(entity.getPrice())
                .stockQuantity(entity.getStockQuantity())
                .build();
    }

    // 도메인 로직, 비지니스 로직
    public void updateStock(int quantity) {
        int newQuantity = this.stockQuantity + quantity;
        if(newQuantity < 0) {
            throw new IllegalArgumentException("재고가 부족합니다. 현재 재고: " + this.stockQuantity);
        }
        this.stockQuantity = newQuantity;
    }



}
