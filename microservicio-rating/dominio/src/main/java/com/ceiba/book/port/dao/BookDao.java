package com.ceiba.book.port.dao;

import com.ceiba.book.model.dto.BookDTO;

import java.util.List;

public interface BookDao {

    BookDTO getById(Long id);

    List<BookDTO> getAll();
}
