package com.ceiba.rating.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rating.command.RatingCommand;
import com.ceiba.rating.command.factory.RatingCreateRequestFactory;
import com.ceiba.rating.service.CreateRatingService;
import org.springframework.stereotype.Component;

@Component
public class RatingCreateHandler implements ManejadorComandoRespuesta<RatingCommand, ComandoRespuesta<Long>> {

    private final RatingCreateRequestFactory createRequestFactory;
    private final CreateRatingService createRatingService;

    public RatingCreateHandler(RatingCreateRequestFactory createRequestFactory,
                               CreateRatingService createRatingService) {
        this.createRequestFactory = createRequestFactory;
        this.createRatingService = createRatingService;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(RatingCommand ratingCommand) {
        return new ComandoRespuesta<>(
                createRatingService.execute(
                        createRequestFactory.execute(ratingCommand)));
    }

}
