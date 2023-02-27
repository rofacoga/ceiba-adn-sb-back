package com.ceiba.rating.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rating.command.AllRatingDataCommand;
import com.ceiba.rating.command.factory.RatingStarsToUpdateFactory;
import com.ceiba.rating.model.entity.Rating;
import com.ceiba.rating.service.UpdateStarsRatingService;
import org.springframework.stereotype.Component;

@Component
public class UpdateStarsRatingHandler implements ManejadorComandoRespuesta<AllRatingDataCommand, ComandoRespuesta<Rating>> {

    private final RatingStarsToUpdateFactory ratingStarsToUpdateFactory;
    private final UpdateStarsRatingService updateAllBookDataService;

    public UpdateStarsRatingHandler(RatingStarsToUpdateFactory ratingStarsToUpdateFactory,
                                    UpdateStarsRatingService updateAllBookDataService) {
        this.ratingStarsToUpdateFactory = ratingStarsToUpdateFactory;
        this.updateAllBookDataService = updateAllBookDataService;
    }

    @Override
    public ComandoRespuesta<Rating> ejecutar(AllRatingDataCommand allRatingDataCommand) {
        return new ComandoRespuesta<>(
                this.updateAllBookDataService.execute(
                        this.ratingStarsToUpdateFactory.execute(allRatingDataCommand)));
    }
}
