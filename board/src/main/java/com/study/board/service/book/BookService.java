package com.study.board.service.book;

import com.study.board.api.dto.request.BookRequest;
import com.study.board.api.dto.request.BookSearchRequest;
import com.study.board.domains.book.model.Book;
import com.study.board.service.book.dto.BookServiceRequest;

import java.util.List;

public interface BookService {
    Book saveBook(BookRequest request);
    Book getBookById(Long id);
    Book updateStock(Long id, Integer quantity);
    void deleteBook(Long id);
    List<Book> searchBooks(BookSearchRequest request);
}
