package com.ceiba.rating.service;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.book.port.dao.BookDao;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.rating.model.entity.Rating;
import com.ceiba.rating.port.repository.RatingRepository;

public class CreateRatingService {
    private static final String ERROR_MESSAGE_BOOK_REQUIRED = "The Book is required for create the Rating";

    private final RatingRepository ratingRepository;
    private final BookDao bookDao;


    public CreateRatingService(RatingRepository ratingRepository, BookDao bookDao) {
        this.ratingRepository = ratingRepository;
        this.bookDao = bookDao;
    }


    public Long execute(Rating rating) {
        this.validateBookExist(rating.getBookId());

        return this.ratingRepository.save(rating);
    }

    private void validateBookExist(Long bookId) {
        BookDTO book = this.bookDao.getById(bookId);
        ValidadorArgumento.validarObligatorio(book, ERROR_MESSAGE_BOOK_REQUIRED);
    }
}
