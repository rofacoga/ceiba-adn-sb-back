package com.ceiba.rating.model.dto;

import com.ceiba.rating.model.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RatingDTO {

    private Long id;
    private Long bookId;
    private int stars;

    public Rating toEntity() {
        return new Rating(id, bookId, stars);
    }
}
