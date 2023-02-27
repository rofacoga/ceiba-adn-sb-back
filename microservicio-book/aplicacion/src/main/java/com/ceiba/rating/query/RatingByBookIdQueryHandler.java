package com.ceiba.rating.query;

import com.ceiba.rating.model.dto.RatingDTO;
import com.ceiba.rating.port.dao.RatingDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingByBookIdQueryHandler {

    private final RatingDao ratingDao;

    public RatingByBookIdQueryHandler(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    public List<RatingDTO> execute(Long bookId) {
        return this.ratingDao.getByBookId(bookId);
    }
}
