package com.ceiba.rating.adapter.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rating.model.entity.Rating;
import com.ceiba.rating.port.repository.RatingRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RatingRepositoryMySQL implements RatingRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace = "ratings", value = "create")
    private static String sqlCreate;
    @SqlStatement(namespace = "ratings", value = "update-stars")
    private static String sqlUpdateAllData;


    public RatingRepositoryMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long save(Rating rating) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("bookId", rating.getBookId());
        paramSource.addValue("stars", rating.getStars());

        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCreate);
    }

    @Override
    public Long updateStars(Rating rating) {
        this.customNamedParameterJdbcTemplate.actualizar(rating, sqlUpdateAllData);

        return rating.getId();
    }
}
