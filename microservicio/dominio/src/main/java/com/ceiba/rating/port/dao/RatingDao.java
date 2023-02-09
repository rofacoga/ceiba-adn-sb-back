package com.ceiba.rating.port.dao;

import com.ceiba.rating.model.dto.RatingDTO;

import java.util.List;

public interface RatingDao {

    RatingDTO getById(Long id);

    List<RatingDTO> getAllOrderByBookId();

    List<RatingDTO> getByBookId(Long bookId);
}
