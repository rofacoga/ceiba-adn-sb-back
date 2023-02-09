package com.ceiba.rating.service;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.rating.model.dto.RatingDTO;
import com.ceiba.rating.model.entity.Rating;
import com.ceiba.rating.port.dao.RatingDao;
import com.ceiba.rating.port.repository.RatingRepository;

public class UpdateStarsRatingService {
    public static final String ERROR_MESSAGE_BOOK_NOT_EXIST = "The rating to update does not exist";

    private final RatingRepository ratingRepository;
    private final RatingDao ratingDao;

    public UpdateStarsRatingService(RatingRepository ratingRepository, RatingDao ratingDao) {
        this.ratingRepository = ratingRepository;
        this.ratingDao = ratingDao;
    }

    public Rating execute(Rating rating) {
        validateBasicData(rating);

        var id = this.ratingRepository.updateStars(rating);

        return this.ratingDao.getById(id).toEntity();
    }

    private void validateBasicData(Rating rating) {
        ValidadorArgumento.validarObligatorio(rating, ERROR_MESSAGE_BOOK_NOT_EXIST);
        ValidadorArgumento.validarObligatorio(rating.getBookId(), ERROR_MESSAGE_BOOK_NOT_EXIST);

        var ratingToUpdate = this.ratingDao.getById(rating.getId());
        ValidadorArgumento.validarObligatorio(ratingToUpdate, ERROR_MESSAGE_BOOK_NOT_EXIST);

        validateBookIdsAreEquals(rating, ratingToUpdate);
    }

    private static void validateBookIdsAreEquals(Rating rating, RatingDTO ratingToUpdate) {
        if (!ratingToUpdate.getBookId().equals(rating.getBookId())) {
            throw new ExcepcionValorInvalido(ERROR_MESSAGE_BOOK_NOT_EXIST);
        }
    }
}
