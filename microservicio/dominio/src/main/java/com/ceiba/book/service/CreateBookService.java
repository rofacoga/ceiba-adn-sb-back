package com.ceiba.book.service;

import com.ceiba.book.model.entity.Book;
import com.ceiba.book.port.repository.BookRepository;

public class CreateBookService {
    private final BookRepository bookRepository;

    public CreateBookService(BookRepository repositorioFactura) {
        this.bookRepository = repositorioFactura;
    }

    public Long execute(Book book) {
        return bookRepository.save(book);
    }
}
