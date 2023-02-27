package com.ceiba.rating.adapter.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.rating.model.entity.Rating;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RatingMapper implements RowMapper<Rating>, MapperResult {

    @Override
    public Rating mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var bookId = resultSet.getLong("id_book");
        var stars = resultSet.getInt("stars");

        return new Rating(id, bookId, stars);
    }
}
