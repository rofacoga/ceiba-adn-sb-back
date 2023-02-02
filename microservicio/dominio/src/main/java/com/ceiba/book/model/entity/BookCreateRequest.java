package com.ceiba.book.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCreateRequest {

    private final String title;
    private final String author;
}
