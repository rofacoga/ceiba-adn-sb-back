package com.ceiba.rating.command.factory;

import com.ceiba.rating.command.AllRatingDataCommand;
import com.ceiba.rating.model.entity.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingStarsToUpdateFactory {

    public Rating execute(AllRatingDataCommand allRatingDataCommand) {
        return new Rating(allRatingDataCommand.getId(), allRatingDataCommand.getBookId(), allRatingDataCommand.getStars());
    }
}
