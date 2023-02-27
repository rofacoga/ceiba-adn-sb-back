package com.ceiba.configuracion;

import com.ceiba.book.port.dao.BookDao;
import com.ceiba.rating.port.dao.RatingDao;
import com.ceiba.rating.port.repository.RatingRepository;
import com.ceiba.rating.service.CreateRatingService;
import com.ceiba.rating.service.UpdateStarsRatingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public CreateRatingService createRatingService(RatingRepository ratingRepository, BookDao bookDao) {
        return new CreateRatingService(ratingRepository, bookDao);
    }

    @Bean
    public UpdateStarsRatingService updateStarsRatingService(RatingRepository ratingRepository, RatingDao ratingDao) {
        return new UpdateStarsRatingService(ratingRepository, ratingDao);
    }
}
