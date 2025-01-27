package com.study.board.infrastructure.book.repository;

import com.study.board.domains.book.model.Book;
import com.study.board.infrastructure.book.entity.BookJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// <데이터베이스와 매핑될 엔티티 클래스, 해당 엔티티 클래스의 기본 키 타입>
public interface BookJpaRepository extends JpaRepository<BookJpaEntity, Long> {

    // 자바로 만드는 쿼리
    @Query("SELECT b FROM BookJpaEntity b WHERE b.id = :id AND b.isDeleted = false")
    Optional<BookJpaEntity> findActiveById(@Param("id") Long id);

    // 책 search
    @Query("SELECT b FROM BookJpaEntity b " +
            "WHERE (:title IS NULL OR b.title LIKE %:title%)" +
            "AND (:author IS NULL OR b.author LIKE %:author%)" +
            "AND (:minPrice IS NULL OR b.price >= :minPrice)" +
            "AND (:maxPrice IS NULL OR b.price <= :maxPrice)")
    List<BookJpaEntity> searchByCriteria(
            @Param("title") String title,
            @Param("author") String author,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice
    );
}
