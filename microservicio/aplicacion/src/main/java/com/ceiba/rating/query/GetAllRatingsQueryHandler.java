package com.ceiba.rating.query;

import com.ceiba.rating.model.dto.RatingDTO;
import com.ceiba.rating.port.dao.RatingDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllRatingsQueryHandler {

    private final RatingDao ratingDao;

    public GetAllRatingsQueryHandler(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    public List<RatingDTO> execute() {
        return this.ratingDao.getAllOrderByBookId();
    }
}
