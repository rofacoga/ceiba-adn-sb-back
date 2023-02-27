package com.ceiba.book;

import com.ceiba.BasePrueba;
import com.ceiba.book.builder.BookTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    void buildWithoutIdMustBeThrowError() {
        BasePrueba.assertThrows(() -> new BookTestDataBuilder()
                        .withDefaultBookData()
                        .withId(null)
                        .build(),
                ExcepcionValorObligatorio.class,
                "The Id is required for the Book");
    }

    @Test
    void buildWithoutTitleMustBeThrowError() {
        BasePrueba.assertThrows(() -> new BookTestDataBuilder()
                        .withDefaultBookData()
                        .withTitle(null)
                        .build(),
                ExcepcionValorObligatorio.class,
                "The Title is required for the Book");
    }

    @Test
    void buildWithTitleHas2CharactersMustBeThrowError() {
        BasePrueba.assertThrows(() -> new BookTestDataBuilder()
                        .withDefaultBookData()
                        .withTitle("El")
                        .build(),
                ExcepcionLongitudValor.class,
                "The Title must contain at least 3 characters");
    }

    @Test
    void buildWithoutAuthorMustBeThrowError() {
        BasePrueba.assertThrows(() -> new BookTestDataBuilder()
                        .withDefaultBookData()
                        .withAuthor(null)
                        .build(),
                ExcepcionValorObligatorio.class,
                "The Author is required for the Book");
    }

    @Test
    void buildWithAuthorHas1CharacterMustBeThrowError() {
        BasePrueba.assertThrows(() -> new BookTestDataBuilder()
                        .withDefaultBookData()
                        .withAuthor("A")
                        .build(),
                ExcepcionLongitudValor.class,
                "The Author name must contain at least 3 characters");
    }

    @Test
    void mustBeCreatedABookWithoutIdSuccessful() {
        final var expectedTitle = "Mil años de soledad";
        final var expectedAuthor = "Gabriel Garcia Marquez";

        var book = new BookTestDataBuilder()
                .withDefaultBookData()
                .buildWithoutId();

        Assertions.assertNull(book.getId());
        Assertions.assertEquals(expectedTitle, book.getTitle());
        Assertions.assertEquals(expectedAuthor, book.getAuthor());
    }

    @Test
    void mustBeCreatedABookWithAllDataSuccessful() {
        final var expectedId = 1L;
        final var expectedTitle = "Mil años de soledad";
        final var expectedAuthor = "Gabriel Garcia Marquez";

        var book = new BookTestDataBuilder()
                .withDefaultBookData()
                .build();

        Assertions.assertEquals(expectedId, book.getId());
        Assertions.assertEquals(expectedTitle, book.getTitle());
        Assertions.assertEquals(expectedAuthor, book.getAuthor());
    }
}
