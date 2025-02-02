package com.study.board.domains.book.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE) // 정적팩토리메서드를 쓰게 한다는거
@Getter
public class Category {
    private String name;
    private String code;

    public static Category createCategory(String name, String code) {
        return Category.builder()
                .name(name)
                .code(code)
                .build();
    }
}
