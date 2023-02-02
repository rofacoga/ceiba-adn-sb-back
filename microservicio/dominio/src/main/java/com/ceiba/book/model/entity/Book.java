package com.ceiba.book.model.entity;

import com.ceiba.dominio.ValidadorArgumento;

public class Book {

    private static final String ERROR_MESSAGE_TITLE_REQUIRED = "The Title is required for the Book";
    private static final String ERROR_MESSAGE_AUTHOR_REQUIRED = "The Author is required for the Book";

    private Long id;
    private final String title;
    private final String author;


    public Book(Long id, String title, String author) {
        ValidadorArgumento.validarObligatorio(title, ERROR_MESSAGE_TITLE_REQUIRED);
        ValidadorArgumento.validarObligatorio(author, ERROR_MESSAGE_AUTHOR_REQUIRED);

        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        // TODO: Terminar validaciones (logitud, datos del contenidos)
        ValidadorArgumento.validarObligatorio(title, ERROR_MESSAGE_TITLE_REQUIRED);
        ValidadorArgumento.validarObligatorio(author, ERROR_MESSAGE_AUTHOR_REQUIRED);

        this.title = title;
        this.author = author;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
