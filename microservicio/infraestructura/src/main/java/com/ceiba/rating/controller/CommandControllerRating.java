package com.ceiba.rating.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rating.command.AllRatingDataCommand;
import com.ceiba.rating.command.RatingCommand;
import com.ceiba.rating.command.handler.RatingCreateHandler;
import com.ceiba.rating.command.handler.UpdateStarsRatingHandler;
import com.ceiba.rating.model.entity.Rating;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
@Tag(name = "Rating command controller")
public class CommandControllerRating {

    private final RatingCreateHandler ratingCreateHandler;
    private final UpdateStarsRatingHandler updateStarsRatingHandler;

    public CommandControllerRating(RatingCreateHandler ratingCreateHandler,
                                   UpdateStarsRatingHandler updateStarsRatingHandler) {
        this.ratingCreateHandler = ratingCreateHandler;
        this.updateStarsRatingHandler = updateStarsRatingHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create", description = "Method used to create the ratings")
    public ComandoRespuesta<Long> create(@RequestBody RatingCommand bookCommand) {
        return this.ratingCreateHandler.ejecutar(bookCommand);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update stars in the rating", description = "Method used to update the stars for a rating")
    public ComandoRespuesta<Rating> updateAllBookData(@RequestBody AllRatingDataCommand allBookDataCommand) {
        return this.updateStarsRatingHandler.ejecutar(allBookDataCommand);
    }
}
