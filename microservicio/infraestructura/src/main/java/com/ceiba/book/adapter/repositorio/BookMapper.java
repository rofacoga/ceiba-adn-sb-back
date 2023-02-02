package com.ceiba.book.adapter.repositorio;

import com.ceiba.book.model.entity.Book;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book>, MapperResult {

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var title = resultSet.getString("title");
        var author = resultSet.getString("author");

        return new Book(id, title, author);
    }
}
