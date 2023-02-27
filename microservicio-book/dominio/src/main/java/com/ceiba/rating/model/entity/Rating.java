package com.ceiba.rating.model.entity;

import com.ceiba.dominio.ValidadorArgumento;

public class Rating {

    private static final long MAX_STARS = 5L;
    private static final long MIN_STARS = 0L;
    private static final String ERROR_MESSAGE_ID_REQUIRED = "The Id is required for the Rating";
    private static final String ERROR_MESSAGE_BOOK_ID_REQUIRED = "The Book id is required for the Rating";
    private static final String ERROR_MESSAGE_STARS_REQUIRED = "The Stars is required for the Rating";
    private static final String ERROR_MESSAGE_STARS_QUANTITY = String.format("The Stars must be greater than or equal to %s or less than or equal to %s", MIN_STARS, MAX_STARS);

    private Long id;
    private Long bookId;
    private int stars;

    public Rating(Long bookId, int stars) {
        this.setBookId(bookId);
        this.setStars(stars);
    }

    public Rating(Long id, Long bookId, int stars) {
        this.setId(id);
        this.setBookId(bookId);
        this.setStars(stars);
    }


    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        ValidadorArgumento.validarObligatorio(id, ERROR_MESSAGE_ID_REQUIRED);

        this.id = id;
    }


    public Long getBookId() {
        return bookId;
    }

    private void setBookId(Long bookId) {
        ValidadorArgumento.validarObligatorio(bookId, ERROR_MESSAGE_BOOK_ID_REQUIRED);

        this.bookId = bookId;
    }


    public int getStars() {
        return stars;
    }

    private void setStars(int stars) {
        ValidadorArgumento.validarObligatorio(stars, ERROR_MESSAGE_STARS_REQUIRED);
        ValidadorArgumento.validarMenor(Long.valueOf(stars), MAX_STARS, ERROR_MESSAGE_STARS_QUANTITY);
        ValidadorArgumento.validarMenor(MIN_STARS, Long.valueOf(stars), ERROR_MESSAGE_STARS_QUANTITY);

        this.stars = stars;
    }
}
