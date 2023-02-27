package com.ceiba.rating.controller;

import com.ceiba.rating.model.dto.RatingDTO;
import com.ceiba.rating.query.GetAllRatingsQueryHandler;
import com.ceiba.rating.query.RatingByBookIdQueryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@Tag(name = "Rating query controller")
public class QueryControllerRating {

    private final GetAllRatingsQueryHandler getAllRatingsQueryHandler;
    private final RatingByBookIdQueryHandler ratingByBookIdQueryHandler;

    public QueryControllerRating(GetAllRatingsQueryHandler getAllRatingsQueryHandler,
                                 RatingByBookIdQueryHandler ratingByBookIdQueryHandler) {
        this.getAllRatingsQueryHandler = getAllRatingsQueryHandler;
        this.ratingByBookIdQueryHandler = ratingByBookIdQueryHandler;
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Method used to get all books")
    public List<RatingDTO> getAll() {
        return this.getAllRatingsQueryHandler.execute();
    }

    @GetMapping("/{id-book}")
    @Operation(summary = "Get by Id", description = "Method used to get a book")
    public List<RatingDTO> getById(@PathVariable("id-book") Long id) {
        return this.ratingByBookIdQueryHandler.execute(id);
    }
}
