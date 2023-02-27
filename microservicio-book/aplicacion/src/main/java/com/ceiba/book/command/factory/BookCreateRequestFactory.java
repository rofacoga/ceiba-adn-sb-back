package com.ceiba.book.command.factory;

import com.ceiba.book.command.BookCommand;
import com.ceiba.book.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookCreateRequestFactory {

    public Book execute(BookCommand bookCommand) {
        return new Book(bookCommand.getTitle(), bookCommand.getAuthor());
    }
}
