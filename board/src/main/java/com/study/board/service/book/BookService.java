package com.study.board.service.book;

import com.study.board.api.dto.request.BookUpdateRequest;
import com.study.board.domains.book.model.Book;
import com.study.board.service.book.dto.BookSearchCriteria;
import com.study.board.service.book.dto.BookServiceRequest;
import com.study.board.service.book.dto.BookServiceUpdateRequest;

import java.util.List;

public interface BookService {
    Book saveBook(BookServiceRequest request);
    Book getBookById(Long id);
    Book updateStock(Long id, Integer quantity);
    void deleteBook(Long id);
    List<Book> searchBooks(BookSearchCriteria request);
    Book updateById(Long id, BookServiceUpdateRequest request);
    Book getBooksByAuthor(String author);
}
