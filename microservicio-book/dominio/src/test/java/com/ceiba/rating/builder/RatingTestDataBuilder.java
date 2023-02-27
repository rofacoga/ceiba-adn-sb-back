package com.ceiba.rating.builder;

import com.ceiba.rating.model.entity.Rating;

public class RatingTestDataBuilder {

    private Long id;
    private Long bookId;
    private Integer stars;


    public RatingTestDataBuilder withDefaultBookData() {
        this.id = 1L;
        this.bookId = 2L;
        this.stars = 4;

        return this;
    }

    public RatingTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RatingTestDataBuilder withBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public RatingTestDataBuilder withStars(Integer stars) {
        this.stars = stars;
        return this;
    }


    public Rating build() {
        return new Rating(this.id, this.bookId, this.stars);
    }

    public Rating buildWithoutId() {
        return new Rating(this.bookId, this.stars);
    }
}
