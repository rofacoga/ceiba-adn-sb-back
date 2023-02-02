package com.ceiba.book.adapter.repositorio;

import com.ceiba.book.model.entity.Book;
import com.ceiba.book.port.repository.BookRepository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryMySQL implements BookRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace = "books", value = "create")
    private static String sqlCreate;


    public BookRepositoryMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long save(Book book) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", null);
        paramSource.addValue("author", book.getAuthor());
        paramSource.addValue("title", book.getTitle());

        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCreate);
    }
}
