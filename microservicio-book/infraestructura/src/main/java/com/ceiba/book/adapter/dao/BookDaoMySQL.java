package com.ceiba.book.adapter.dao;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.book.port.dao.BookDao;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoMySQL implements BookDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "books", value = "get-all")
    private static String sqlGetAll;
    @SqlStatement(namespace = "books", value = "get-by-id")
    private static String sqlGetById;

    public BookDaoMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public BookDTO getById(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlGetById, paramSource, new BookDtoMapper()));
    }

    @Override
    public List<BookDTO> getAll() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlGetAll, new BookDtoMapper());
    }
}
