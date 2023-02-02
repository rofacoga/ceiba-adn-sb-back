package com.ceiba.book.query;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.book.port.dao.BookDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllBooksQueryHandler {

    private final BookDao bookDao;

    public GetAllBooksQueryHandler(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<BookDTO> execute() {
        return this.bookDao.getAll();
    }
}
