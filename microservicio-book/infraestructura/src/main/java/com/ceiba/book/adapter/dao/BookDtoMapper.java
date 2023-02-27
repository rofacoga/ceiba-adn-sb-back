package com.ceiba.book.adapter.dao;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookDtoMapper implements RowMapper<BookDTO>, MapperResult {

    @Override
    public BookDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var title = resultSet.getString("title");
        var author = resultSet.getString("author");

        return new BookDTO(id, title, author);
    }
}
