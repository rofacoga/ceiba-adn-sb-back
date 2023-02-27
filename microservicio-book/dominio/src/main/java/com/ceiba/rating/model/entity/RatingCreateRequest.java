package com.ceiba.rating.model.entity;

public class RatingCreateRequest {

    private Long id;
    private final Long bookId;
    private final int stars;

    public RatingCreateRequest(Long bookId, int stars) {
        this.bookId = bookId;
        this.stars = stars;
    }

    public RatingCreateRequest(Long id, Long bookId, int stars) {
        this.id = id;
        this.bookId = bookId;
        this.stars = stars;
    }


    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public int getStars() {
        return stars;
    }
}
