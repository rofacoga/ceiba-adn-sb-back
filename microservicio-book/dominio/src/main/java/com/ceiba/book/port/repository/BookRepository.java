package com.ceiba.book.port.repository;

import com.ceiba.book.model.entity.Book;

public interface BookRepository {

    Long save(Book book);

    Long update(Book book);
}
