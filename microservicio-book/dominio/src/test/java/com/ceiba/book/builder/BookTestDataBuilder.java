package com.ceiba.book.builder;

import com.ceiba.book.model.entity.Book;

public class BookTestDataBuilder {

    private Long id;
    private String title;
    private String author;


    public BookTestDataBuilder withDefaultBookData() {
        this.id = 1L;
        this.title = "Mil años de soledad";
        this.author = "Gabriel Garcia Marquez";

        return this;
    }

    public BookTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public BookTestDataBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookTestDataBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }


    public Book build() {
        return new Book(this.id, this.title, this.author);
    }

    public Book buildWithoutId() {
        return new Book(this.title, this.author);
    }
}
