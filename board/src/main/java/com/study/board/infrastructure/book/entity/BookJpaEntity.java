package com.study.board.infrastructure.book.entity;

import com.study.board.domains.book.model.Book;
import com.study.board.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Builder
@AllArgsConstructor
// 기본 생성자 만들어주는 것, accessLevel은 엔티티를 무분별하게 생성하지 못하도록(빌더나 정적팩토리 메서드를 쓰도록 강요됨)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// 데이터베이스와 직접 매핑 되는 JPA 엔티티 클래스
public class BookJpaEntity extends BaseEntity {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 AI
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stockQuantity;

    // Book 도메인 객체를 entity 객체로 변환하는 거
    public static BookJpaEntity from(Book book) {
        BookJpaEntity entity = new BookJpaEntity();
        entity.title = book.getTitle();
        entity.author = book.getAuthor();
        entity.isbn = book.getIsbn();
        entity.price = book.getPrice();
        entity.stockQuantity = book.getStockQuantity();
        return entity;
    }

    // 엔티티 수정 가격, 갯수 메서드
    public void update(Book book) {
        this.price = book.getPrice();
        this.stockQuantity = book.getStockQuantity();
    }

}
