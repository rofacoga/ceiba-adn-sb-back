package com.ceiba.book.model.dto;

import com.ceiba.book.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDTO {
    private Long id;
    private String title;
    private String author;

    public Book toEntity() {
        return new Book(id, title, author);
    }
}
