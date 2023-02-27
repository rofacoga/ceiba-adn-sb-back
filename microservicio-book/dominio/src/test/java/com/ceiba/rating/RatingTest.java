package com.ceiba.rating;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.rating.builder.RatingTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RatingTest {

    @Test
    void buildWithoutIdMustBeThrowError() {
        BasePrueba.assertThrows(() -> new RatingTestDataBuilder()
                        .withDefaultBookData()
                        .withId(null)
                        .build(),
                ExcepcionValorObligatorio.class,
                "The Id is required for the Rating");
    }

    @Test
    void buildWithoutBookIdMustBeThrowError() {
        BasePrueba.assertThrows(() -> new RatingTestDataBuilder()
                        .withDefaultBookData()
                        .withBookId(null)
                        .build(),
                ExcepcionValorObligatorio.class,
                "The Book id is required for the Rating");
    }

    @Test
    void buildWith7StarsMustBeThrowError() {
        BasePrueba.assertThrows(() -> new RatingTestDataBuilder()
                        .withDefaultBookData()
                        .withStars(7)
                        .build(),
                ExcepcionValorInvalido.class,
                "The Stars must be greater than or equal to 0 or less than or equal to 5");
    }

    @Test
    void buildWithLeft1StarsMustBeThrowError() {
        BasePrueba.assertThrows(() -> new RatingTestDataBuilder()
                        .withDefaultBookData()
                        .withStars(-1)
                        .build(),
                ExcepcionValorInvalido.class,
                "The Stars must be greater than or equal to 0 or less than or equal to 5");
    }

    @Test
    void mustBeCreatedABookWithoutIdSuccessful() {
        final var expectedBookId = 2L;
        final var expectedStars = 4;

        var book = new RatingTestDataBuilder()
                .withDefaultBookData()
                .buildWithoutId();

        Assertions.assertNull(book.getId());
        Assertions.assertEquals(expectedBookId, book.getBookId());
        Assertions.assertEquals(expectedStars, book.getStars());
    }

    @Test
    void mustBeCreatedABookWithAllDataSuccessful() {
        final var expectedId = 1L;
        final var expectedBookId = 2L;
        final var expectedStars = 4;

        var book = new RatingTestDataBuilder()
                .withDefaultBookData()
                .build();

        Assertions.assertEquals(expectedId, book.getId());
        Assertions.assertEquals(expectedBookId, book.getBookId());
        Assertions.assertEquals(expectedStars, book.getStars());
    }
}
