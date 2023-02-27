package com.ceiba.book.query;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.book.port.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookByIdQueryHandler {

    private final BookDao bookDao;

    public BookByIdQueryHandler(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookDTO execute(Long id) {
        return this.bookDao.getById(id);
    }
}
