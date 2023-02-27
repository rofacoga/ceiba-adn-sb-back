package com.ceiba.rating.command.factory;

import com.ceiba.rating.command.RatingCommand;
import com.ceiba.rating.model.entity.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingCreateRequestFactory {

    public Rating execute(RatingCommand ratingCommand) {
        return new Rating(ratingCommand.getBookId(), ratingCommand.getStars());
    }
}
