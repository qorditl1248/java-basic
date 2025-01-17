package dev.study.exam2;

import java.util.List;

public record Member(
        int memberId,
        String name,
        List<Book> borrowedBooks
) {

}
