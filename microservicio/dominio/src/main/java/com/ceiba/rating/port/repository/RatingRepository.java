package com.ceiba.rating.port.repository;

import com.ceiba.rating.model.entity.Rating;

public interface RatingRepository {
    Long save(Rating rating);

    Long updateStars(Rating rating);
}
