package com.ceiba.book.service;

import com.ceiba.book.model.entity.Book;
import com.ceiba.book.port.dao.BookDao;
import com.ceiba.book.port.repository.BookRepository;
import com.ceiba.dominio.ValidadorArgumento;

public class UpdateAllBookDataService {
    public static final String ERROR_MESSAGE_BOOK_NOT_EXIST = "The book to update does not exist";

    private final BookRepository bookRepository;
    private final BookDao bookDao;

    public UpdateAllBookDataService(BookRepository bookRepository, BookDao bookDao) {
        this.bookRepository = bookRepository;
        this.bookDao = bookDao;
    }

    public Book execute(Book book) {
        var bookToUpdate = this.bookDao.getById(book.getId());
        ValidadorArgumento.validarObligatorio(bookToUpdate, ERROR_MESSAGE_BOOK_NOT_EXIST);
        var id = this.bookRepository.update(book);

        return this.bookDao.getById(id).toEntity();
    }
}
