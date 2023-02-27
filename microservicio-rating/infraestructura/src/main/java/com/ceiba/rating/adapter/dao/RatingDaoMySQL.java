package com.ceiba.rating.adapter.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rating.model.dto.RatingDTO;
import com.ceiba.rating.port.dao.RatingDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingDaoMySQL implements RatingDao {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ratings", value = "get-by-id")
    private static String sqlGetById;
    @SqlStatement(namespace = "ratings", value = "get-all-order-by-book-id")
    private static String sqlGetAllOrderByBookId;
    @SqlStatement(namespace = "ratings", value = "get-all-by-book-id")
    private static String sqlGetAllByBookId;


    public RatingDaoMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public RatingDTO getById(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlGetById, paramSource, new RatingDtoMapper()));
    }

    @Override
    public List<RatingDTO> getAllOrderByBookId() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlGetAllOrderByBookId, new RatingDtoMapper());
    }

    @Override
    public List<RatingDTO> getByBookId(Long bookId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("bookId", bookId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlGetAllByBookId, paramSource, new RatingDtoMapper());
    }
}
