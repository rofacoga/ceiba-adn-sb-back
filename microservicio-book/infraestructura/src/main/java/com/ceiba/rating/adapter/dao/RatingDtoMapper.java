package com.ceiba.rating.adapter.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.rating.model.dto.RatingDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RatingDtoMapper implements RowMapper<RatingDTO>, MapperResult {

    @Override
    public RatingDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var bookId = resultSet.getLong("id_book");
        var stars = resultSet.getInt("stars");

        return new RatingDTO(id, bookId, stars);
    }
}
