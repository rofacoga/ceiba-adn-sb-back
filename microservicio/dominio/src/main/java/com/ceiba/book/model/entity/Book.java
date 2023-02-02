package com.ceiba.book.model.entity;

import com.ceiba.dominio.ValidadorArgumento;

public class Book {

    private static final String ERROR_MESSAGE_ID_REQUIRED = "The Id is required for the Book";
    private static final String ERROR_MESSAGE_TITLE_REQUIRED = "The Title is required for the Book";
    private static final String ERROR_MESSAGE_AUTHOR_NAME_CONTAIN_AT_LEAST = "The Author name must contain at least 3 characters";
    private static final String ERROR_MESSAGE_AUTHOR_REQUIRED = "The Author is required for the Book";
    private static final String ERROR_MESSAGE_TITLE_CONTAIN_AT_LEAST = "The Title must contain at least 3 characters";

    private Long id;
    private String title;
    private String author;


    public Book(Long id, String title, String author) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
    }

    public Book(String title, String author) {
        this.setTitle(title);
        this.setAuthor(author);
    }


    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        ValidadorArgumento.validarObligatorio(id, ERROR_MESSAGE_ID_REQUIRED);

        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        ValidadorArgumento.validarObligatorio(title, ERROR_MESSAGE_TITLE_REQUIRED);
        ValidadorArgumento.validarLongitudMinima(title, 3, ERROR_MESSAGE_TITLE_CONTAIN_AT_LEAST);

        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        ValidadorArgumento.validarObligatorio(author, ERROR_MESSAGE_AUTHOR_REQUIRED);
        ValidadorArgumento.validarLongitudMinima(author, 3, ERROR_MESSAGE_AUTHOR_NAME_CONTAIN_AT_LEAST);

        this.author = author;
    }
}
